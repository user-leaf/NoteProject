package com.sesame.noteproject.databinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sesame.noteproject.R;

public class DatabindingActivity extends AppCompatActivity {

    User user;
    ActivityDatabindingBinding mBinding;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, DatabindingActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_databinding);

        user = new User("jett", "123");

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        mBinding.setUser(user);

        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(user.getName() + "1");
                }
            }
        }.start();
    }
}
