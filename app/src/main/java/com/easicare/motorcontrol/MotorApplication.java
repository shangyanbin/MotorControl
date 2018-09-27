package com.easicare.motorcontrol;

import android.app.Application;

public class MotorApplication extends Application {

    private static SerialPortOperation serialPortOperation;

    @Override
    public void onCreate() {
        super.onCreate();
        serialPortOperation = new SerialPortOperation();
    }

    public static SerialPortOperation getSerialPortOperation() {
        return serialPortOperation;
    }
}
