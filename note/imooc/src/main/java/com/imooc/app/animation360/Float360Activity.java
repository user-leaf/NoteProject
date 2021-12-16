package com.imooc.app.animation360;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.imooc.app.R;
import com.imooc.app.animation360.service.MyFloatService;

public class Float360Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float360);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyFloatService.class);
        startService(intent);
        finish();
    }
}
