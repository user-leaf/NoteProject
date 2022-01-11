package com.sesame.module_test.test_signin;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);

        findViewById(R.id.btnShow).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new MyDialogFragment().show(getSupportFragmentManager(), "my");
    }
}
