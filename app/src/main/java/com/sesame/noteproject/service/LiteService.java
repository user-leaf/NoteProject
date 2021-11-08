package com.sesame.noteproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.sesame.noteproject.IMyAidlInterface;

public class LiteService extends Service {
    public static final String TAG = LiteService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyAidlInterfaceImpl();
    }

    class MyAidlInterfaceImpl extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String getServerProcessName(String clientProcessName) throws RemoteException {
            Log.d(TAG, "服务进程, thread: " + Thread.currentThread().getName());
            Log.d(TAG, "客户进程: " + clientProcessName);
            String currentProcessName = ProcessUtil.getCurrentProcessName(LiteService.this);
            Log.d(TAG, "当前进程: " + currentProcessName);
            return currentProcessName;
        }
    }
}
