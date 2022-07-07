package com.bamboo.module_test2.test8_try_catch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;

public class TryCatchActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test8_try_catch);

        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                String str = null;
                try {
                    if (true) {
                        str.toString();
                    }
                }catch (Exception e){
                    System.out.println("catch");
                }finally {
                    System.out.println("finally");
                }
                break;
        }
    }
}
