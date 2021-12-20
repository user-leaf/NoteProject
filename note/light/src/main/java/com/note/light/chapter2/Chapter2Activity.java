package com.note.light.chapter2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.note.light.R;

public class Chapter2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private TextInputLayout mTlUsername;
    private TextInputLayout mTlPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);

        View btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "hehe", Snackbar.LENGTH_SHORT).setAction("点击事件", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Chapter2Activity.this, "haha", Toast.LENGTH_SHORT).show();
                    }
                }).setDuration(Snackbar.LENGTH_LONG).show();
            }
        });


        mEtUsername = findViewById(R.id.etUsername);
        mEtPassword = findViewById(R.id.etPassword);
        mTlUsername = findViewById(R.id.tl_username);
        mTlPassword = findViewById(R.id.tl_password);
        findViewById(R.id.btnLogin).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                if (!validateUsername(username)) {
                    mTlUsername.setErrorEnabled(true);
                    mTlUsername.setError("用户名有误");
                    return;
                } else {
                    mTlUsername.setErrorEnabled(false);
                }

                if (!validatePassword(password)) {
                    mTlPassword.setErrorEnabled(true);
                    mTlPassword.setError("密码格式有误");
                    return;
                } else {
                    mTlPassword.setErrorEnabled(false);
                }


                break;
        }
    }

    private boolean validateUsername(String username) {
        return username.length() >= 6;
    }

    private boolean validatePassword(String password) {
        return password.length() >= 6;
    }
}
