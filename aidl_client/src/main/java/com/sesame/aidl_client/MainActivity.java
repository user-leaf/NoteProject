package com.sesame.aidl_client;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtNum1;
    private EditText mEtNum2;
    private Button mBtnCommit;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtNum1 = findViewById(R.id.etNum1);
        mEtNum2 = findViewById(R.id.etNum2);
        mBtnCommit = findViewById(R.id.btnCommit);
        mTvResult = findViewById(R.id.tvResult);

        mBtnCommit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCommit:
                String s1 = mEtNum1.getText().toString();
                String s2 = mEtNum2.getText().toString();
                if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || !TextUtils.isDigitsOnly(s1) || !TextUtils.isDigitsOnly(s1)){
                    Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
                    return;
                }
                int a = Integer.parseInt(s1);
                int b = Integer.parseInt(s2);
                mTvResult.setText(String.valueOf(a * b));
                break;
        }
    }
}