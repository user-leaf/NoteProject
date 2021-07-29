package com.sesame.module_test;

import android.app.Application;

import com.sesame.module_base.AppCompat;
import com.sesame.module_base.ServiceFactory;

public class TestApplication extends Application implements AppCompat {
    private static Application application;

    @Override
    public void initialize(Application app) {
        application = app;
        ServiceFactory.getInstance().setTestService(new TestServiceImpl());
    }

    public static Application getApplication() {
        return application;
    }
}
