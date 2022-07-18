package com.bamboo.module_test2;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

public class Test2Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}
