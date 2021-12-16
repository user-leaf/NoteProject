package com.imooc.app.animation360.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.imooc.app.animation360.engine.FloatViewManager;

public class MyFloatService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        FloatViewManager manager = FloatViewManager.getInstance(this);
        manager.showFloatCircleView();
        super.onCreate();
    }
}
