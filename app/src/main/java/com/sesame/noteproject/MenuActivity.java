package com.sesame.noteproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sesame.noteproject.anim.AnimActivity;
import com.sesame.noteproject.arouter.VRouterPath;
import com.sesame.noteproject.deeplink.DeeplinkActivity;
import com.sesame.noteproject.merge.MergeActivity;
import com.sesame.noteproject.databinding.DatabindingActivity;
import com.sesame.noteproject.refresh.RefreshActivity;
import com.sesame.noteproject.test_company.TitleActivity;
import com.sesame.noteproject.websocket.WebSocketActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tvMerge, R.id.tvTitleBar, R.id.tvARouter, R.id.tvDeeplink, R.id.tvAnim, R.id.tvRefresh, R.id.tvWebSocket, R.id.tvDataBinding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvMerge:
                MergeActivity.startActivity(this);
                break;
            case R.id.tvTitleBar:
                TitleActivity.startActivity(this);
                break;
            case R.id.tvARouter:
                ARouter.getInstance().build(VRouterPath.Activity_ARouter)
                        .withString("key1", "good")
                        .withLong("id", 1000L)
                        .navigation(this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Toast.makeText(MenuActivity.this, "onFound", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Toast.makeText(MenuActivity.this, "onLost", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Toast.makeText(MenuActivity.this, "onArrival", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                runOnUiThread(() -> Toast.makeText(MenuActivity.this, "onInterrupt", Toast.LENGTH_SHORT).show());
                            }
                        });
                break;
            case R.id.tvDeeplink:
                DeeplinkActivity.startActivity(this);
                break;
            case R.id.tvAnim:
                AnimActivity.startActivity(this);
                break;
            case R.id.tvRefresh:
                RefreshActivity.startActivity(this);
                break;
            case R.id.tvWebSocket:
                WebSocketActivity.startActivity(this);
                break;
            case R.id.tvDataBinding:
                DatabindingActivity.startActivity(this);
                break;
        }
    }
}
