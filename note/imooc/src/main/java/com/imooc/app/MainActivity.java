package com.imooc.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.imooc.app.update.AppUpdater;
import com.imooc.app.update.net.INetCallback;
import com.imooc.app.update.net.INetDownloadCallback;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private View mBtnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUpdate = findViewById(R.id.btnUpdate);
        mBtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                接口屏蔽实现的好处
                NetManager一行实现的代码都没有写，但整个流程的代码可以刷刷往下写了。
                 */
                String json;


                AppUpdater.getInstance().getNetManager().get("", new INetCallback() {
                    @Override
                    public void success(String response) {
                        // 1. 解析json
                        // 2. 做版本匹配
                        // 如果需要更新
                        // 3. 弹框
                        // 4. 点击下载



                        AppUpdater.getInstance().getNetManager().download("", null, new INetDownloadCallback() {
                            @Override
                            public void success(File apkFile) {
                                // 安装的代码
                            }

                            @Override
                            public void progress(int progress) {
                                // 更新界面的代码
                            }

                            @Override
                            public void failed(Throwable throwable) {

                            }
                        });
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        throwable.printStackTrace();
                        Toast.makeText(MainActivity.this, "版本更新接口请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}