package com.bamboo.module_test2.test7_kotlin;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

public class MyEditText extends androidx.appcompat.widget.AppCompatEditText {

    public MyEditText(Context context) {
        this(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHintTextColor(Color.RED);

    }


}
