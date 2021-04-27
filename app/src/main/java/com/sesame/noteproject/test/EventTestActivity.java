package com.sesame.noteproject.test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

/**
 * 事件分发
 */
public class EventTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);

        /*
        顶级的view接收到点击事件以后,就会按照分发机制一层层的分发事件.如果其中的某一个view的ontouchevent返回了false,那么它父容器的ontouchevent将会被调用

         */



    }
}
