package com.sesame.aidl_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    private static final String TAG = RemoteService.class.getSimpleName();

    public RemoteService() {
    }

    /**
     * 当客户端绑定到该服务的时候会执行
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return iBinder;
    }

    private IBinder iBinder = new IRemoteService.Stub() {
        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.d(TAG, "收到了远程的请求 num1 = " + num1 + ", num2 = " + num2);
            return num1 + num2;
        }
    };
}