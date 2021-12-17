package com.sesame.module_test.test_lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.sesame.module_test.R;

public class LottieActivity extends AppCompatActivity implements View.OnClickListener {

    private LottieAnimationView lottieAnimatorView;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        lottieAnimatorView = findViewById(R.id.lottieView);
        lottieAnimatorView.setAnimation("animators/data_en.json");
        lottieAnimatorView.setRepeatCount(ValueAnimator.INFINITE);

        findViewById(R.id.btnPlay).setOnClickListener(this);
        findViewById(R.id.btnPause).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);

        lottieAnimatorView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        lottieAnimatorView.setMinAndMaxProgress(0f, 1.f);
        findViewById(R.id.btnProgress).setOnClickListener(this);
        iv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                lottieAnimatorView.playAnimation();
                break;

            case R.id.btnPause:
                lottieAnimatorView.pauseAnimation();
                break;

            case R.id.btnCancel:
                lottieAnimatorView.cancelAnimation();
                break;

            case R.id.btnProgress:
                lottieAnimatorView.setProgress(0.12f);
                break;


        }
    }
}
