package com.sesame.module_test.test1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

import java.lang.ref.WeakReference;

public class Thread2Activity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler);

        mHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Toast.makeText(Thread2Activity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        };

//        mHandler = new MyHandler(this);

        new MyThread2(this).start();
    }

    public static class MyHandler extends Handler {
        private WeakReference<Thread2Activity> mWeakReference;

        //
        public MyHandler(Thread2Activity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mWeakReference == null) {
                return;
            }
            if (mWeakReference.get() != null) {
                Toast.makeText(mWeakReference.get(), "aaa", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public static class MyThread2 extends Thread {
        private WeakReference<Thread2Activity> mWeakReference;

        public MyThread2(Thread2Activity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mWeakReference == null) {
                return;
            }

//            Thread2Activity activity = mWeakReference.get();
//            if (activity == null) {
//                return;
//            }
//            activity.mHandler.sendEmptyMessage(1);

            if (mWeakReference.get() != null) {
                mWeakReference.get().mHandler.sendEmptyMessage(1);
            }

        }
    }
}
