package com.sesame.noteproject.anim;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

public class AnimActivity extends AppCompatActivity {

    private TextView tv;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, AnimActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        tv = findViewById(R.id.tv);
    }

    public void onClick(View view) {
        tv.setTextColor(getResources().getColor(R.color.colorPrimary));
        ObjectAnimator textColorAnim = ObjectAnimator.ofArgb(tv, "textColor",
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary)
        );
//        textColorAnim.setEvaluator(new ArgbEvaluator());
        textColorAnim.setDuration(3000);
        textColorAnim.start();

//        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
//        alphaAnim.setDuration(3000);
//        alphaAnim.start();

//        ObjectAnimator heightAnim = ObjectAnimator.ofInt(tv, "height", 100, 200, 100);
//        heightAnim.setDuration(3000).start();

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(
//                getResources().getColor(R.color.colorAccent),
//                getResources().getColor(R.color.colorPrimary),
//                getResources().getColor(R.color.colorAccent)
//        );
//        valueAnimator.addUpdateListener(animation -> tv.setTextColor((Integer) animation.getAnimatedValue()));
//        valueAnimator.setDuration(3000);
//        valueAnimator.start();

//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(
//                ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f),
//                ObjectAnimator.ofInt(tv, "height", 100, 200, 100)
//        );
//        animatorSet.setDuration(3000);
//        animatorSet.start();
    }
}
