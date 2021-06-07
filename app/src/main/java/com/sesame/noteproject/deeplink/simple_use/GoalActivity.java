package com.sesame.noteproject.deeplink.simple_use;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        TextView tv = findViewById(R.id.tv);
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            String host = uri.getHost();
            String scheme = uri.getScheme();
            if ("share".equals(host)) {
                tv.setText("host:" + host + "\nscheme:" + scheme + "\n值：" + uri.getPathSegments());
            }
        }
    }
}
