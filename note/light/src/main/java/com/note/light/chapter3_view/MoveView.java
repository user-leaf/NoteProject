package com.note.light.chapter3_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class MoveView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public MoveView(Context context) {
        super(context);
        mScroller = new Scroller(context);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                // 法1
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                // 法2
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
                // 法3
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                // 方法5
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int dx = destX - scrollX;
        int scrollY = getScrollY();
        int dy = destY - scrollY;
        mScroller.startScroll(scrollX, 0, dx, dy, 2000);
        invalidate();
    }
}
