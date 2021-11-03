package com.sesame.noteproject.service;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;
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

        mRxPermissions = new RxPermissions(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStartService:
                mRxPermissions
                        .request(Manifest.permission.WRITE_SETTINGS, Manifest.permission.SYSTEM_ALERT_WINDOW)
                        .subscribe(granted -> {
                            if (granted) {
                                Intent intent = new Intent(this, MyService.class);
                                intent.putExtra("dialog", true);
                                startService(intent);
                            }
                        });

//                Intent intent = new Intent(this, MyService.class);
//                intent.putExtra("dialog", true);
//                startService(intent);
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
        }
    }
}
