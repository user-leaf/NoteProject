package com.sesame.module_kotlin;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.sesame.module_kotlin.jetpack.lifecycle.application.ApplicationObserver;

public class KotlinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }
}
