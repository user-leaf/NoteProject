package com.imooc.app.update.net;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpNetManager implements INetManager {

    private static OkHttpClient sOkHttpClient;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
        sOkHttpClient = builder.build();

    }

    @Override
    public void get(String url, INetCallback callback) {
        // requestbuilder -> Request -> Call -> execute/enqueue
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).get().build();
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
                }catch (Throwable throwable){
                    throwable.printStackTrace();
                    callback.failed(throwable);
                }
            }
        });
    }

    @Override
    public void download(String url, File targetFile, INetDownloadCallback callback) {

    }
}
