package com.imooc.app.update;

import com.imooc.app.update.net.INetManager;
import com.imooc.app.update.net.OkHttpNetManager;

public class AppUpdater {

    // 网络请求，下载的能力
    // okhttp, volley, httpclient, httpurlconnection
    private INetManager mNetManager = new OkHttpNetManager();

//    public void setNetManager(INetManager manager){
//        mNetManager = manager;
//    }

    public INetManager getNetManager() {
        return mNetManager;
    }

    private AppUpdater() {
    }

    private static AppUpdater instance = new AppUpdater();

    public static AppUpdater getInstance() {
        return instance;
    }

}
