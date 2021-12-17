package com.sesame.module_test.test_android_gesture;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

public class GestureActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        tv = findViewById(R.id.tv1);

        GestureDetector gestureDetector = new GestureDetector(this, new MyGestureListener());

        tv.setClickable(true); // 不加这个触发不了
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "双击了", Toast.LENGTH_SHORT).show();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Toast.makeText(GestureActivity.this, "单击了", Toast.LENGTH_SHORT).show();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            Toast.makeText(GestureActivity.this, "长按了", Toast.LENGTH_SHORT).show();
        }
    }
}
