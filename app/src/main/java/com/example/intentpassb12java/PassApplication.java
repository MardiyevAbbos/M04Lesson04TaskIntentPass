package com.example.intentpassb12java;

import android.app.Application;
import android.util.Log;

public class PassApplication extends Application{

    static final String TAG = PassApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "PassApplication onCreate!!!");
    }
}
