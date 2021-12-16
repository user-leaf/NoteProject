package com.imooc.app.animation360.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyProgressView extends View {
    private int width = 100;
    private int height = 100;
    private Paint mCirclePaint;
    private Paint mProgressPaint;
    private Paint mTextPaint;
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private Path path = new Path();
    private int progress = 50;
    private int max = 100;

    public MyProgressView(Context context) {
        super(context);
        init();
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(Color.argb(0xff, 0x3a, 0x8c, 0x6c));

        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setColor(Color.argb(0xff, 0x4e, 0xc9, 0x63));
        mProgressPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 只绘制重叠部分

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(25);

        // 绘制到一个图片上，再将图片绘制到画布上
        // 创建一个空图片
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(mBitmap); // 创建一个画布
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmapCanvas.drawCircle(width / 2, height / 2, width / 2, mCirclePaint);
        path.reset();
        float y = (1 - (float) progress / max) * height;
        path.moveTo(width, y);
        path.lineTo(width, height);// 连接到右下角
        path.lineTo(0, height); // 连接到左下角
        path.lineTo(0, y);// 平行
        // 画贝塞尔曲线3次
        for (int i = 0; i < 3; i++) {
            path.rQuadTo(10, -10, 20, 0);
            path.rQuadTo(10, 10, 20, 0);
        }
        path.close();
        mBitmapCanvas.drawPath(path, mProgressPaint);
        String text = (int) (((float) progress / max) * 100) + "%";
        float textWidth = mTextPaint.measureText(text);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float baseLine = height / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;
        mBitmapCanvas.drawText(text, width / 2 - textWidth / 2, baseLine, mTextPaint);
        canvas.drawBitmap(mBitmap, 0, 0, null);
        //super.onDraw(canvas);
    }
}
