package com.imooc.app.animation360.engine;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.imooc.app.animation360.view.FloatCircleView;
import com.imooc.app.animation360.view.FloatMenuView;

import java.lang.reflect.Field;

public class FloatViewManager {

    private Context mContext;
    private FloatCircleView mCircleView;
    private final WindowManager mWindowManager; // 通过这个windowmanager来操控浮窗体的显示和隐藏以及位置的改变
    private View.OnTouchListener mCircleViewTouchListener = new View.OnTouchListener() {

        private float y0;
        private float x0;
        private float mStartX;
        private float mStartY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // touch三个动作的监听
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mStartX = event.getRawX();
                    x0 = event.getRawX();
                    y0 = event.getRawY();
                    mStartY = event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float x = event.getRawX();
                    float y = event.getRawY();
                    float dx = x - mStartX;
                    float dy = y - mStartY;
                    mParams.x += dx;
                    mParams.y += dy;
                    mCircleView.setDragState(true);
                    mWindowManager.updateViewLayout(mCircleView, mParams);
                    mStartX = x;
                    mStartY = y;
                    break;
                case MotionEvent.ACTION_UP:
                    // 手指离开的时候
                    float x1 = event.getRawX();
                    if (x1 > getScreenWidth() / 2) {
                        mParams.x = getScreenWidth() - mCircleView.width; // todo params
                    } else {
                        mParams.x = 0;
                    }
                    mCircleView.setDragState(false);
                    mWindowManager.updateViewLayout(mCircleView, mParams);
                    if (Math.abs(x1 - x0) > 6) { // 说明是拖拽事件，消费掉
                        return true;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
            return false;
        }
    };
    private final FloatMenuView mFloatMenuView;

    public int getScreenWidth() {
        return mWindowManager.getDefaultDisplay().getWidth(); // todo
    }

    public int getScreenHeight() {
        return mWindowManager.getDefaultDisplay().getHeight();
    }

    public int getStatusHeight() {
        try {

            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object o = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = (int) field.get(o);
            return mContext.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            return 0;
        }
    }

    private WindowManager.LayoutParams mParams;

    private FloatViewManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mCircleView = new FloatCircleView(context);
        mCircleView.setOnTouchListener(mCircleViewTouchListener);
        mCircleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 隐藏circleView，同时显示菜单栏，同时开启动画，从下往上滑出来的动画
                mWindowManager.removeView(mCircleView);
                showFloatMenuView();
                mFloatMenuView.startAnimation();
            }
        });
        mFloatMenuView = new FloatMenuView(context);
    }

    private void showFloatMenuView() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = getScreenWidth();
        params.height = getScreenHeight() - getStatusHeight();
        params.gravity = Gravity.BOTTOM | Gravity.LEFT;
        params.x = 0;
        params.y = 0;
        params.type = WindowManager.LayoutParams.TYPE_PHONE; // 像手机打电话界面始终处在最上方
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;// 特征 不去抢焦点
        params.format = PixelFormat.RGBA_8888; // 背景透明
        mWindowManager.addView(mFloatMenuView, params);
    }

    private static FloatViewManager instance;

    public static FloatViewManager getInstance(Context context) {
        if (instance == null) {
            synchronized (FloatViewManager.class) {
                if (instance == null) {
                    instance = new FloatViewManager(context);
                }
            }
        }
        return instance;
    }

    /**
     * 展示浮窗小球到窗口上
     */
    public void showFloatCircleView() {
        if (mParams == null) {
            mParams = new WindowManager.LayoutParams();
            mParams.width = mCircleView.width;
            mParams.height = mCircleView.height;
            mParams.gravity = Gravity.TOP | Gravity.LEFT;
            mParams.x = 0;
            mParams.y = 0;
            mParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 像手机打电话界面始终处在最上方
            mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;// 特征 不去抢焦点
            mParams.format = PixelFormat.RGBA_8888; // 背景透明
        }
        mWindowManager.addView(mCircleView, mParams);
    }

    public void hideFloatMenuView() {
        mWindowManager.removeView(mFloatMenuView);
    }
}
