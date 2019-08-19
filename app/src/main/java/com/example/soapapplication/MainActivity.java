package com.example.soapapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mylibrary.MyDialog;
import com.example.mylibrary.OnConvertListener;
import com.example.mylibrary.TempratureConvertor;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDialog myDialog = new MyDialog(this);
        myDialog.show();

        TempratureConvertor convertor = new TempratureConvertor(1);
        convertor.setC(35);
        Log.e(TAG, convertor.getF()+"");

        List<Double> doubles = Arrays.asList(10d, 15d, 25d, 35d);
        Log.e("C Tempratures",doubles+"");
        convertor.toFDegrees(doubles, new OnConvertListener() {
            @Override
            public void result(List<Double> converted) {
                Log.e("F Tempratures callback",converted+"");
            }
        });
    }
}
