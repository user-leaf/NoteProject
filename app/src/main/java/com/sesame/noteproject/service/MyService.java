package com.sesame.noteproject.service;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.sesame.noteproject.R;
import com.tbruyelle.rxpermissions3.RxPermissions;

public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        boolean dialog = intent.getBooleanExtra("dialog", false);
        if (dialog){
            Log.d(TAG, "onStartCommand: show dialog true");
            AlertDialog alertDialog = new AlertDialog.Builder(MyService.this, R.style.Theme_AppCompat_Dialog)
                    .setTitle("title")
                    .setMessage("dialog in service")
                    .create();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//6.0 　　　　　　
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            }else {
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            }
//            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
