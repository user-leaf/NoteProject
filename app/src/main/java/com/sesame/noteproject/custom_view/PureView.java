package com.sesame.noteproject.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class PureView extends AppCompatTextView {

    private static final String TAG = PureView.class.getSimpleName();
    private Paint paint;

    public PureView(@NonNull Context context) {
        this(context, null);
    }

    public PureView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PureView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setColor(0xff00ff00);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG, "onMeasure1: " + getMeasuredHeight() + ", " + getHeight());
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(250, 250);
        Log.d(TAG, "onMeasure2: " + getMeasuredHeight() + ", " + getHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout1: " + getMeasuredHeight() + ", " + getHeight());
        setHeight(100);
        Log.d(TAG, "onLayout2: " + getMeasuredHeight() + ", " + getHeight());
        getLayoutParams().height = 101;
        Log.d(TAG, "onLayout3: " + getMeasuredHeight() + ", " + getHeight());
        setMeasuredDimension(250, 102);
        Log.d(TAG, "onLayout4: " + getMeasuredHeight() + ", " + getHeight());
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l + 50, t + 50, r + 50, b + 50);
        /*
        左上右下依次加50看变化。
        背景色是橙色的。
        只有l+50时，由于右侧位置未变，中间的绿色圆圈显示不全。但可以看到中间绿色圆圈的位置确实是发生改变了。
         */
        Log.d(TAG, "layout1: " + getMeasuredHeight() + ", " + getHeight());
        setHeight(100);
        Log.d(TAG, "layout2: " + getMeasuredHeight() + ", " + getHeight());
        getLayoutParams().height = 101;
        Log.d(TAG, "layout3: " + getMeasuredHeight() + ", " + getHeight());
        setMeasuredDimension(250, 102);
        Log.d(TAG, "layout4: " + getMeasuredHeight() + ", " + getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(50, 50, 20, paint);
    }
}
