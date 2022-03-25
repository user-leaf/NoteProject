package com.note.light.chapter3_view2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class MoveView2 extends View {

    private float lastX, lastY;
    private float offsetX, offsetY;

    public MoveView2(Context context) {
        super(context);
    }

    public MoveView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = x - lastX;
                offsetY = y - lastY;
//                //方法1
//                layout((int) (getLeft() + offsetX), (int) (getTop() + offsetY), (int) (getRight() + offsetX), (int) (getBottom() + offsetY));

                // 方法2
//                offsetLeftAndRight((int) offsetX);
//                offsetTopAndBottom((int) offsetY);

                // 方法3-1
//                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = (int) (getLeft() + offsetX);
//                layoutParams.topMargin = (int) (getTop() + offsetY);
//                setLayoutParams(layoutParams);

                // 方法3-2
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                layoutParams.leftMargin = (int) (getLeft() + offsetX);
//                layoutParams.topMargin = (int) (getTop() + offsetY);
//                setLayoutParams(layoutParams);

                // 方法4 动画

                // 方法5 scrollTo/scrollBy
                ((View)getParent()).scrollBy((int) -offsetX, (int) -offsetY);

                // 方法6 Scroller

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }
}
