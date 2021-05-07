package com.sesame.noteproject.toolbar;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sesame.noteproject.R;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(view -> Toast.makeText(ToolbarActivity.this, "toolbar", Toast.LENGTH_SHORT).show());
    }

    public Toolbar getToolBar() {
        return mToolbar;
    }
}
