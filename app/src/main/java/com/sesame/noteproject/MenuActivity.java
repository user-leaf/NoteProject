package com.sesame.noteproject;

import android.content.Intent;
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
import com.sesame.noteproject.callphone.CallPhoneActivity;
import com.sesame.noteproject.databinding.DatabindingActivity;
import com.sesame.noteproject.deeplink.DeeplinkActivity;
import com.sesame.noteproject.flexbox.FlexboxActivity;
import com.sesame.noteproject.lazyfragment.LazyActivity;
import com.sesame.noteproject.md.MaterialDesignActivity;
import com.sesame.noteproject.merge.MergeActivity;
import com.sesame.noteproject.nulltest.NullTestActivity;
import com.sesame.noteproject.refresh.RefreshActivity;
import com.sesame.noteproject.rv.RVDemoActivity;
import com.sesame.noteproject.service.ServiceDemoActivity;
import com.sesame.noteproject.test.EventTestActivity;
import com.sesame.noteproject.test_company.TitleActivity;
import com.sesame.noteproject.uri.UriActivity;
import com.sesame.noteproject.viewbinding.ViewBindingStudyJavaActivity;
import com.sesame.noteproject.vm.VmActivity;
import com.sesame.noteproject.vm_livedata.TimerLiveDataActivity;
import com.sesame.noteproject.vm_livedata.TimerWithLiveDataActivity;
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

    @OnClick({R.id.tvMerge, R.id.tvTitleBar, R.id.tvARouter, R.id.tvDeeplink, R.id.tvAnim, R.id.tvRefresh, R.id.tvWebSocket, R.id.tvDataBinding, R.id.tvRecyclerView, R.id.tvKotlinNull, R.id.tvViewModel, R.id.tvLiveData, R.id.tvLiveDataKt, R.id.tvMd, R.id.tvCallPhone, R.id.tvViewBinding, R.id.tvModule, R.id.tvFlexbox, R.id.tvUri, R.id.tvEventTest, R.id.tvService, R.id.tvLazyLoadFragment})
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
            case R.id.tvRecyclerView:
                RVDemoActivity.startActivity(this);
                break;
            case R.id.tvKotlinNull:
                NullTestActivity.Companion.startActivity(this);
                break;
            case R.id.tvViewModel:
                VmActivity.startActivity(this);
                break;
            case R.id.tvLiveData:
                TimerWithLiveDataActivity.startActivity(this);
                break;
            case R.id.tvLiveDataKt:
                startActivity(new Intent(this, TimerLiveDataActivity.class));
                break;

            case R.id.tvMd:
                MaterialDesignActivity.startActivity(this);
                break;
            case R.id.tvCallPhone:
                startActivity(new Intent(this, CallPhoneActivity.class));
                break;
            case R.id.tvViewBinding:
                startActivity(new Intent(this, ViewBindingStudyJavaActivity.class));
                break;
            case R.id.tvModule:
                startActivity(new Intent(this, ModulesActivity.class));
                break;
            case R.id.tvFlexbox:
                startActivity(new Intent(this, FlexboxActivity.class));
                break;
            case R.id.tvUri:
                startActivity(new Intent(this, UriActivity.class));
                break;

            case R.id.tvEventTest:
                startActivity(new Intent(this, EventTestActivity.class));
                break;

            case R.id.tvService:
                startActivity(new Intent(this, ServiceDemoActivity.class));
                break;

            case R.id.tvLazyLoadFragment:
                startActivity(new Intent(this, LazyActivity.class));
                break;
        }
    }
}
