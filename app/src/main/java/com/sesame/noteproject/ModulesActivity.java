package com.sesame.noteproject;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_base.ServiceFactory;

public class ModulesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnTest).setOnClickListener(this);
        findViewById(R.id.btnFragment1).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                ServiceFactory.getInstance().getKotlinService().launch(this);
                break;
            case R.id.btnTest:
                ServiceFactory.getInstance().getTestService().launch(this);
                break;
            case R.id.btnFragment1:
                ServiceFactory.getInstance().getKotlinService().getFragment(getSupportFragmentManager(), R.id.container, new Bundle());
                break;
        }
    }
}
