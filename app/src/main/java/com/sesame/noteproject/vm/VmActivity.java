package com.sesame.noteproject.vm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.sesame.noteproject.R;

/*
《ViewModel的基本使用》
https://zhuanlan.zhihu.com/p/76361500
 */
public class VmActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, VmActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vm);
        initView();
    }

    private void initView() {
        TextView tvTime = findViewById(R.id.tvTime);
        /*
        ViewModel的实例化并不是通过普通的new来完成的，而是通过ViewModelProviders来完成。
        ViewModelProviders会去判断ViewModel是否存在，若存在则直接返回，否则它会去创建一个ViewModel。
         */
        TimerViewModel timerViewModel = ViewModelProviders.of(this).get(TimerViewModel.class);
        /*
        通过自定义接口的方式来实现ViewModel到Activity的通信，这不是一种好的方法，android提供了LiveData组件来解决这个问题。
        通过LiveData，当ViewModel中的数据发生变化，Activity能自动收到通知，从而更新UI。
         */
        timerViewModel.setOnTimeChangedListener(second -> runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /*
                要观察的数据：second
                 */
                tvTime.setText("Time: " + second);
            }
        }));
        timerViewModel.startTiming();
    }
}
