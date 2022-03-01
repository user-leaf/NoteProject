package com.sesame.module_test.test_viewpager2;

import android.content.res.Resources;
import android.util.TypedValue;

public class UIUtils {
    public static int dip2px(float dip) {
        Resources r = Resources.getSystem();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, r.getDisplayMetrics());
    }
}
