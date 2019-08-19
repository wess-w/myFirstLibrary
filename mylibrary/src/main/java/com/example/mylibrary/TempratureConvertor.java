package com.example.mylibrary;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Class For Converting Temprature from Celsuis to Fahrenheit
 */

public class TempratureConvertor {

    private double C;

    public TempratureConvertor() {
    }

    public TempratureConvertor(double c) {
        C = c;
    }

    public void setC(double c) {
        C = c;
    }

    public double getF() {
        return (C * 9 / 5) + 32;
    }

    public void toFDegrees(List<Double> degreesInC, final OnConvertListener convertListener) {

        final List<Double> converted = new ArrayList<>();
        Observable.fromIterable(degreesInC)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Double, Double>() {
                    @Override
                    public Double apply(Double aDouble) throws Exception {
                        return (aDouble * 9 / 5) + 32;
                    }
                })
                .subscribe(new Observer<Double>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Double aDouble) {
                        converted.add(aDouble);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        convertListener.result(converted);
                    }
                });
    }
}
