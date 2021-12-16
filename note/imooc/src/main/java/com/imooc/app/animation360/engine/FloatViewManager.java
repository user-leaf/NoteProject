package com.imooc.app.animation360.engine;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;

import com.imooc.app.animation360.view.FloatCircleView;

public class FloatViewManager {

    private Context mContext;
    private FloatCircleView mCircleView;
    private final WindowManager mWindowManager; // 通过这个windowmanager来操控浮窗体的显示和隐藏以及位置的改变

    private FloatViewManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mCircleView = new FloatCircleView(context);
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
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = mCircleView.width;
        params.height = mCircleView.height;
        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 0;
        params.type = WindowManager.LayoutParams.TYPE_PHONE; // 像手机打电话界面始终处在最上方
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;// 特征 不去抢焦点
        params.format = PixelFormat.RGBA_8888; // 背景透明
        mWindowManager.addView(mCircleView, params);
    }
}
