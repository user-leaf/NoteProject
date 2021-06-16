package com.sesame.noteproject.refresh.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        TextView tv = findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent != null) {
            int param = intent.getIntExtra("param", -1);
            if (param != -1) {
                tv.setText(param);
            }
        }
    }
}
