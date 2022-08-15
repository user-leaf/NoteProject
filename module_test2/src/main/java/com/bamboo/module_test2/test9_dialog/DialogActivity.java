package com.bamboo.module_test2.test9_dialog;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test9_dialog);

        findViewById(R.id.btnShowDialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
        // 怎么应用呢？
        new MyDialog().show(getSupportFragmentManager(), "aaa");
    }
}
