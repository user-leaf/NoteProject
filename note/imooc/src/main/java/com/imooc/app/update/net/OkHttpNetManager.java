package com.imooc.app.update.net;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpNetManager implements INetManager {

    private static final String TAG = OkHttpNetManager.class.getSimpleName();
    private static OkHttpClient sOkHttpClient;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        sOkHttpClient = builder.build();

    }

    @Override
    public void get(String url, INetCallback callback, Object tag) {
        // requestbuilder -> Request -> Call -> execute/enqueue
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().tag(tag).build();
        Call call = sOkHttpClient.newCall(request);
//        Response response = call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    String string = response.body().string();
                    sHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(string);
                        }
                    });
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    callback.failed(throwable);
                }
            }
        });
    }

    @Override
    public void download(String url, File targetFile, INetDownloadCallback callback, Object tag) {
        if (!targetFile.exists()) {
            targetFile.getParentFile().mkdirs();
        }
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().tag(tag).build();
        Call call = sOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                sHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                // 文件的保存
                InputStream is = null;
                OutputStream os = null;
                try {
                    final long totalLen = response.body().contentLength();

                    is = response.body().byteStream();
                    os = new FileOutputStream(targetFile);

                    byte[] buffer = new byte[8 * 1024];
                    long curLen = 0;

                    int bufferLen = 0;
                    while (!call.isCanceled() && (bufferLen = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bufferLen);
                        os.flush();
                        curLen += bufferLen;

                        long finalCurLen = curLen;
                        sHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.progress((int) (finalCurLen * 1.0f / totalLen * 100));
                            }
                        });
                    }
                    if (call.isCanceled()){
                        return;
                    }
                    // 文件有"所有者"这个概念
                    // 需要暴露给系统安装程序去安装，即我的文件需要暴露给别的进程去访问。
                    try {
                        // 文件设置可读、可写、可执行
                        targetFile.setExecutable(true, false);
                        targetFile.setReadable(true, false);
                        targetFile.setWritable(true, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(targetFile);
                        }
                    });
                } catch (Throwable e) {
                    if (call.isCanceled()) {
                        return;
                    }
                    e.printStackTrace();
                    sHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failed(e);
                        }
                    });
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                }
            }
        });
    }

    @Override
    public void cancel(Object tag) {
        List<Call> queuedCalls = sOkHttpClient.dispatcher().queuedCalls();
        if (queuedCalls != null) {
            for (Call call : queuedCalls) {
                if (tag.equals(call.request().tag())) {
                    Log.d(TAG, "find call = " + tag);
                    call.cancel();
                }
            }
        }

        List<Call> runningCalls = sOkHttpClient.dispatcher().runningCalls();
        if (runningCalls != null) {
            for (Call call : runningCalls) {
                if (tag.equals(call.request().tag())) {
                    Log.d(TAG, "find call = " + tag);
                    call.cancel();
                }
            }
        }

    }
}
