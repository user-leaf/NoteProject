package com.note.light.chapter3_view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.note.light.R;

public class ViewMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_move);
        setTitle("View的滑动");

        MoveView moveView = findViewById(R.id.moveView);
        // 方法4
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_view_move);
//        moveView.setAnimation(animation);
        // 方法4-2
//        ObjectAnimator.ofFloat(moveView, "translationX", 0f, 300f).setDuration(2000).start();

//        moveView.smoothScrollTo(-400, -200);
    }
}
