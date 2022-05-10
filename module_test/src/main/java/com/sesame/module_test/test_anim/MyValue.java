package com.sesame.module_test.test_anim;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class MyValue extends androidx.appcompat.widget.AppCompatTextView {

    private int value = 0;

    public MyValue(Context context) {
        super(context);
    }

    public MyValue(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyValue(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        float r = value / 10f;
        setText(r + "%");
    }
}
