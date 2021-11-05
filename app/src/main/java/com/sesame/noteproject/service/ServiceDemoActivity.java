package com.sesame.noteproject.service;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;
import com.sesame.noteproject.test.EventTestActivity;
import com.tbruyelle.rxpermissions3.RxPermissions;

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private RxPermissions mRxPermissions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_service);

        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnDialog).setOnClickListener(this);
        findViewById(R.id.tvStartIntentService).setOnClickListener(this);
        findViewById(R.id.tvStartActivity).setOnClickListener(this);

        mRxPermissions = new RxPermissions(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
//                mRxPermissions
//                        .request(Manifest.permission.WRITE_SETTINGS, Manifest.permission.SYSTEM_ALERT_WINDOW)
//                        .subscribe(granted -> {
//                            if (granted) {
//                                Intent intent = new Intent(this, MyService.class);
//                                intent.putExtra("dialog", true);
//                                startService(intent);
//                            }
//                        });

                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("dialog", true);
                startService(intent);
                break;

            case R.id.btnStopService:
                Intent intent2 = new Intent(this, MyService.class);
                stopService(intent2);
                break;

            case R.id.btnDialog:
                new AlertDialog.Builder(this)
                        .setTitle("title")
                        .setMessage("dialog in service")
                        .create().show();
                break;

            case R.id.tvStartIntentService:
                Intent serviceIntent = new Intent(this, MyIntentService2.class);
                serviceIntent.putExtra("extra", "hahaha");
                startService(serviceIntent);

                System.out.println("running.");
                System.out.println("running..");
                System.out.println("running...");
                break;

            case R.id.tvStartActivity:
                Intent intent1 = new Intent(getApplicationContext(), EventTestActivity.class);
//                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                getApplicationContext().startActivity(intent1);

                start(getApplicationContext(), intent1);
                break;
        }
    }

    public static void start(Context context, Intent intent) {
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

}
