package com.imooc.app.update.net;

import java.io.File;

public interface INetManager {
    /*
     这个接口对外提供什么样的能力
     */

    void get(String url, INetCallback callback);

    void download(String url, File targetFile, INetDownloadCallback callback);
}
