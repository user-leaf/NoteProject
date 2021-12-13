package com.sesame.module_test.test_android_service_connection;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

/**
 * Activity和Service之间的通信
 * 1、binder
 * 2、广播
 * 3、EventBus
 */
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener, ConnService.OnDataChangeListener {

    private ServiceConnection conn;
    private ConnService mService;
    private boolean mBound = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_conn_act_service);

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                System.out.println("onServiceConnected");
                mService = ((ConnService.MyBinder) service).getService();
                mService.setOnDataChangeListener(ServiceActivity.this);
                mBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                // Android 系统会在与服务的连接意外中断时（例如当服务崩溃或被终止时）调用该方法。
                // 注意:当客户端取消绑定时，系统“绝对不会”调用该方法。
                System.out.println("onServiceDisconnected");
                mService = null;
                mBound = false;
            }
        };

        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnGetData).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBindService:
                Intent intent = new Intent(ServiceActivity.this, ConnService.class);
                bindService(intent, conn, BIND_AUTO_CREATE);
                break;

            case R.id.btnGetData:
                if (mBound) {
                    mService.printMsg("hello");
                }
                break;

            case R.id.btnUnbindService:
                unbindService(conn);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void dataChange(String data) {
        System.out.println("data: " + data);
    }
}
