package com.note.light.chapter3_view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.note.light.R;

public class AnimatorDemoActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_animator);

        mButton = findViewById(R.id.btnAnim);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyButton myButton = new MyButton(mButton);
                // todo 效果不太好，不太明白
//                ObjectAnimator animator = ObjectAnimator.ofInt(myButton, "width", 800);
//                animator.setDuration(2000);
//                animator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        Toast.makeText(AnimatorDemoActivity.this, "动画结束", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                animator.start();

                startAnimatorSet();
            }
        });
    }

    private void startAnimatorSet() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mButton, "translationX", 0.f, 200.f, 0.f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mButton, "scaleX", 1.f, 2.f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mButton, "rotationX", 0.f, 90.f, 0.f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.play(animator1).with(animator2).after(animator3);
        set.start();

    }

    static class MyButton {
        Button targetView;

        public MyButton(Button targetView) {
            this.targetView = targetView;
        }

        public Button getWidth() {
            return targetView;
        }

        public void setWidth(int width) {
            targetView.getLayoutParams().width = width;
            targetView.requestLayout();
        }
    }
}
