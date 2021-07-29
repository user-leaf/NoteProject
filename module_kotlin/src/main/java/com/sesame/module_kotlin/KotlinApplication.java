package com.sesame.module_kotlin;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.sesame.module_base.AppCompat;
import com.sesame.module_base.AppConfig;
import com.sesame.module_base.ServiceFactory;
import com.sesame.module_kotlin.jetpack.lifecycle.application.ApplicationObserver;
import com.sesame.module_kotlin.module.KotlinServiceImpl;

public class KotlinApplication extends Application implements AppCompat {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }

    @Override
    public void initialize(Application app) {
        application = app;
        ServiceFactory.getInstance().setKotlinService(new KotlinServiceImpl());
    }

    public static Application getApplication() {
        return application;
    }
}
