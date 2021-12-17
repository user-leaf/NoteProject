package com.imooc.app.animation360.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyProgressView extends View {
    private int width = 200;
    private int height = 200;
    private Paint mCirclePaint;
    private Paint mProgressPaint;
    private Paint mTextPaint;
    private Bitmap mBitmap;
    private Canvas mBitmapCanvas;
    private Path path = new Path();
    private int progress = 50;
    private int max = 100;
    private int currentProgress = 0;
    private int count = 50;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private GestureDetector mDetector;
    private boolean isSingleTag = false;

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

        mDetector = new GestureDetector(getContext(), new MyGestureDetectorListener());
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mDetector.onTouchEvent(event);
            }
        });

        setClickable(true);
    }

    class MyGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            startDoubleTapAnimation();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            isSingleTag = true;
            currentProgress = progress;
            startSingleTapAnimation();
            return super.onSingleTapConfirmed(e);
        }
    }

    private void startSingleTapAnimation() {
        mHandler.postDelayed(mSingleTapRunnable, 200);
    }

    private SingleTapRunnable mSingleTapRunnable = new SingleTapRunnable();

    class SingleTapRunnable implements Runnable {

        @Override
        public void run() {
            count--;
            if (count >= 0) {
                invalidate();
                mHandler.postDelayed(mSingleTapRunnable, 200);
            } else {
                mHandler.removeCallbacks(mSingleTapRunnable);
                count = 50;
            }
        }
    }

    private void startDoubleTapAnimation() {
        mHandler.postDelayed(mDoubleTapRunnable, 50);
    }

    private DoubleTapRunnable mDoubleTapRunnable = new DoubleTapRunnable();

    class DoubleTapRunnable implements Runnable {

        @Override
        public void run() {
            currentProgress++;
            if (currentProgress <= progress) {
                invalidate();
                mHandler.postDelayed(mDoubleTapRunnable, 50);
            } else {
                mHandler.removeCallbacks(mDoubleTapRunnable);
                currentProgress = 0;
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmapCanvas.drawCircle(width / 2, height / 2, width / 2, mCirclePaint);
        path.reset();
        float y = (1 - (float) currentProgress / max) * height;
        path.moveTo(width, y);
        path.lineTo(width, height);// 连接到右下角
        path.lineTo(0, height); // 连接到左下角
        path.lineTo(0, y);// 平行

        if (!isSingleTag) {
            // 画贝塞尔曲线3次
            float d = (1 - ((float) currentProgress / progress)) * 10;
            for (int i = 0; i < 5; i++) {
                path.rQuadTo(10, -d, 20, 0);
                path.rQuadTo(10, d, 20, 0);
            }
        } else {
            // 振幅减小
            float d = (float) count / 50 * 10;
            if (count % 2 == 0) {
                for (int i = 0; i < 5; i++) {
                    path.rQuadTo(20, -d, 40, 0);
                    path.rQuadTo(20, d, 40, 0);
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    path.rQuadTo(20, d, 40, 0);
                    path.rQuadTo(20, -d, 40, 0);
                }
            }
        }

        path.close();
        mBitmapCanvas.drawPath(path, mProgressPaint);
        String text = (int) (((float) currentProgress / max) * 100) + "%";
        float textWidth = mTextPaint.measureText(text);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float baseLine = height / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;
        mBitmapCanvas.drawText(text, width / 2 - textWidth / 2, baseLine, mTextPaint);
        canvas.drawBitmap(mBitmap, 0, 0, null);
        //super.onDraw(canvas);
    }
}
