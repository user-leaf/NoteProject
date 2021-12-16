package com.imooc.app.animation360.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.imooc.app.R;

public class FloatCircleView extends View {

    public int width = 150;
    public int height = 150;
    private Paint mCirclePaint;
    private Paint mTextPaint;
    private String text = "50%";
    private boolean drag = false;
    private Bitmap mBitmap;

    public FloatCircleView(Context context) {
        this(context, null);
    }

    public FloatCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    private void initPaints() {
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GRAY);
        mCirclePaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setTextSize(25);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setFakeBoldText(true);

        Bitmap src = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        // 缩放到小球大小
        // todo bitmap
        mBitmap = Bitmap.createScaledBitmap(src, width, height, true);// filter: 是否保留状态
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        if (drag) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        } else {
            canvas.drawCircle(width / 2, height / 2, width / 2, mCirclePaint);
            float textWidth = mTextPaint.measureText(text);
            float x = width / 2 - textWidth / 2;
            Paint.FontMetrics metrics = mTextPaint.getFontMetrics();// 得到文字规格
            float dy = -(metrics.descent + metrics.ascent) / 2;
            float y = height / 2 + dy; // y为文本 基线baseline的坐标
            canvas.drawText(text, x, y, mTextPaint);
        }
    }

    public void setDragState(boolean b) {
        drag = b;
        invalidate();
    }
}
