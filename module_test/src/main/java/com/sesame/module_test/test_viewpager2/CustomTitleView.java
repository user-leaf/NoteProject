package com.sesame.module_test.test_viewpager2;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

public class CustomTitleView extends ColorTransitionPagerTitleView {
    public CustomTitleView(Context context) {
        super(context);
    }

    @Override
    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
        super.onLeave(index, totalCount, leavePercent, leftToRight);

    }

    @Override
    public void onDeselected(int index, int totalCount) {
        setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
    }

    @Override
    public void onSelected(int index, int totalCount) {
        setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);

    }

    @Override
    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
        super.onEnter(index, totalCount, enterPercent, leftToRight);

    }
}
