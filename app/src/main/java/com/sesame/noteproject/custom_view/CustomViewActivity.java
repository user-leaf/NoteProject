package com.sesame.noteproject.custom_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

public class CustomViewActivity extends AppCompatActivity {

    private PureView pureView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cumstom_view);
        pureView2 = findViewById(R.id.pureView2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pureView2.post(() -> {
            System.out.println("pureView2.getMeasuredHeight(): " + pureView2.getMeasuredHeight());
            System.out.println("pureView2.getHeight(): " + pureView2.getHeight());
        });
    }
}