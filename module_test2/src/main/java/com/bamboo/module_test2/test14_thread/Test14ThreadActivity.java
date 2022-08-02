package com.bamboo.module_test2.test14_thread;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;

public class Test14ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test14_thread);

        new Thread(runnable).start();
    }

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    System.out.println("@@@ run " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("@@@ onDestroy()");
    }
}
