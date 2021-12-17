package com.imooc.app.animation360.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.imooc.app.R;
import com.imooc.app.animation360.engine.FloatViewManager;

public class FloatMenuView extends LinearLayout {

    private final View mLL;
    private final TranslateAnimation mAnimation;

    public FloatMenuView(Context context) {
        super(context);

        View root = View.inflate(getContext(), R.layout.float_menu_view, null);
        mLL = root.findViewById(R.id.ll);
        mAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0);
        mAnimation.setDuration(500);
        mAnimation.setFillAfter(true);
        mLL.setAnimation(mAnimation);
        root.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                FloatViewManager manager = FloatViewManager.getInstance(getContext());
                manager.hideFloatMenuView();
                manager.showFloatCircleView();
                return false;
            }
        });
        addView(root);
    }

    public void startAnimation(){
        mAnimation.start();
    }

}
