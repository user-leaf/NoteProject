package com.sesame.noteproject;

import com.alibaba.android.arouter.launcher.ARouter;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        DeeplinkManager.getInstance().init(this);
    }
}
