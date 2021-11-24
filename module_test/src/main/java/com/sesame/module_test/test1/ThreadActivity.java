package com.sesame.module_test.test1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

import java.lang.ref.WeakReference;

public class ThreadActivity extends AppCompatActivity {

    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1:
                        Toast.makeText(ThreadActivity.this, "完成", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        new MyThread(this).start();

    }
    
    //静态内部类不持有Activity的引用，防止Thread长时间执行下，造成Activity的内存泄漏。
    public static class MyThread extends Thread{
        //静态内部类不持有外部类的引用，无法获取外部的mHandler变量，需要弱引用一个Activity，通过get方法获取
        WeakReference<ThreadActivity> mThreadActivityRef;
        public MyThread(ThreadActivity activity) {
            mThreadActivityRef = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = Message.obtain();
            message.what = 1;
            if (mThreadActivityRef == null)
                return;
            if (mThreadActivityRef.get() != null)
                mThreadActivityRef.get().mHandler.sendMessage(message);
        }
    }

}