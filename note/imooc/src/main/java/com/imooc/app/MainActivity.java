package com.imooc.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.imooc.app.update.AppUpdater;
import com.imooc.app.update.bean.DownloadBean;
import com.imooc.app.update.net.INetCallback;
import com.imooc.app.update.ui.UpdateVersionShowDialog;
import com.imooc.app.update.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
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
                String jsonUrl = "http://59.110.162.30/app_updater_version.json";

                AppUpdater.getInstance().getNetManager().get(jsonUrl, new INetCallback() {
                    @Override
                    public void success(String response) {
                        // 1. 解析json
                        // 2. 做版本匹配
                        // 如果需要更新
                        // 3. 弹框
                        // 4. 点击下载

                        DownloadBean bean = new Gson().fromJson(response, DownloadBean.class);
                        if (bean == null) {
                            Toast.makeText(MainActivity.this, "版本检测接口返回数据异常", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // 检测：是否需要弹框
                        try {
                            long versionCode = Long.parseLong(bean.versionCode);
                            if (versionCode <= AppUtils.getVersionCode(MainActivity.this)) {
                                Toast.makeText(MainActivity.this, "已经是最新版本，无需更新", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "版本检测接口返回版本号异常", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // 3. 弹框
                        UpdateVersionShowDialog.show(MainActivity.this, bean);
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        throwable.printStackTrace();
                        Toast.makeText(MainActivity.this, "版本更新接口请求失败", Toast.LENGTH_SHORT).show();
                    }
                }, MainActivity.this);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppUpdater.getInstance().getNetManager().cancel(this);
    }
}