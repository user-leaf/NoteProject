package com.sesame.module_test.test_android_service_connection;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ConnService extends Service {
    public static final String TAG = ConnService.class.getSimpleName();

    private MyBinder mBinder;
    private OnDataChangeListener mOnDataChangeListener;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        if (mBinder == null) {
            mBinder = new MyBinder();
        }
        return mBinder;
    }

    class MyBinder extends Binder {
        public ConnService getService() {
            return ConnService.this;
        }

        public void userService() {
            System.out.println("user service");
        }
    }

    public void printMsg(String msg) {
        System.out.println("print " + msg);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }


    public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
        this.mOnDataChangeListener = onDataChangeListener;
    }

    interface OnDataChangeListener {
        void dataChange(String data);
    }

}
