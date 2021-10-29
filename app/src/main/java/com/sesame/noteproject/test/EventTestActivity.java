package com.sesame.noteproject.test;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

/**
 * 事件分发
 */
public class EventTestActivity extends AppCompatActivity {
    public static String TAG = EventTestActivity.class.getSimpleName();

    private Button mBtnTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);

        /*
        顶级的view接收到点击事件以后,就会按照分发机制一层层的分发事件.如果其中的某一个view的ontouchevent返回了false,那么它父容器的ontouchevent将会被调用

         */

        mBtnTest = findViewById(R.id.btnTest);
        mBtnTest.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: " + mBtnTest.getMeasuredWidth());
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Log.d(TAG, "onWindowFocusChanged: " + mBtnTest.getMeasuredWidth());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 当View树的状态发生改变或者View树内部的View的可见性发生改变时，onGlobalLayout方法将被回调
        ViewTreeObserver observer = mBtnTest.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mBtnTest.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Log.d(TAG, "onGlobalLayout: " + mBtnTest.getMeasuredWidth());
            }
        });
    }
}
