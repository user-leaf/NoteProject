package com.imooc.app.animation360.engine;

import android.content.Context;
import android.view.WindowManager;

public class FloatViewManager {

    private Context mContext;
    private final WindowManager mWindowManager; // 通过这个windowmanager来操控浮窗体的显示和隐藏以及位置的改变

    private FloatViewManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
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
}
