package com.imooc.app.update.net;

import java.io.File;

public interface INetDownloadCallback {
    void success(File apkFile);

    void progress(int progress);

    void failed(Throwable throwable);

}
