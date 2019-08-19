package com.example.mylibrary;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class MyDialog extends Dialog
{

    public MyDialog(Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
    }

}
