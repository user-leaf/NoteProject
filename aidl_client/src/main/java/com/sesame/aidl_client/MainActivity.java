package com.sesame.aidl_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sesame.aidl_server.IRemoteService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtNum1;
    private EditText mEtNum2;
    private Button mBtnCommit;
    private TextView mTvResult;
    private IRemoteService mIRemoteService;
    private ServiceConnection conn = new ServiceConnection() {

        // 绑定上服务的时候
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 拿到了远程的服务
            mIRemoteService = IRemoteService.Stub.asInterface(service);
        }

        // 断开服务的时候
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 回收资源
            mIRemoteService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtNum1 = findViewById(R.id.etNum1);
        mEtNum2 = findViewById(R.id.etNum2);
        mBtnCommit = findViewById(R.id.btnCommit);
        mTvResult = findViewById(R.id.tvResult);

        mBtnCommit.setOnClickListener(this);

        bindService();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCommit:
                String s1 = mEtNum1.getText().toString();
                String s2 = mEtNum2.getText().toString();
                if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || !TextUtils.isDigitsOnly(s1) || !TextUtils.isDigitsOnly(s1)){
                    Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                try {
                    // 调用远程服务
                    int res = mIRemoteService.add(a, b);
                    mTvResult.setText(String.valueOf(res));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    mTvResult.setText("错误");
                }
                break;
        }
    }

    private void bindService() {
        Intent intent = new Intent();
        // 新版本5.0起 必须显式Intent启动绑定服务
        intent.setComponent(new ComponentName("com.sesame.aidl_server", "com.sesame.aidl_server.RemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}