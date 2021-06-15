package com.sesame.noteproject.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshKernel;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.sesame.noteproject.R;

@SuppressLint("RestrictedApi")
public class LottieRefreshHeader extends LinearLayout implements RefreshHeader {
    private LottieAnimationView lottieAnimationView;
    private TextView tvRefreshTitle;
    private LinearLayout refreshRoot;

    public LottieRefreshHeader(Context context) {
        this(context, null);
    }

    public LottieRefreshHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public LottieRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.include_refresh_header, this, true);
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        refreshRoot = findViewById(R.id.llRefreshRoot);
        tvRefreshTitle = findViewById(R.id.tv_refresh_title);
    }

    public void setRefreshBackground() {
        refreshRoot.setBackgroundColor(0xfff6f8fa);
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        lottieAnimationView.playAnimation();
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        lottieAnimationView.pauseAnimation();
        if (success) {
            tvRefreshTitle.setText("刷新完成");
        } else {
            tvRefreshTitle.setText("刷新失败");
        }
        return 500;//延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                tvRefreshTitle.setText("下拉开始刷新");
                lottieAnimationView.setFrame(0);
//                mArrowView.setVisibility(VISIBLE);//显示下拉箭头
//                mProgressView.setVisibility(GONE);//隐藏动画
//                mArrowView.animate().rotation(0);//还原箭头方向
                break;
            case Refreshing:
                tvRefreshTitle.setText("正在刷新");
                lottieAnimationView.playAnimation();
//                mProgressView.setVisibility(VISIBLE);//显示加载动画
//                mArrowView.setVisibility(GONE);//隐藏箭头
                break;
            case ReleaseToRefresh:
                tvRefreshTitle.setText("释放立即刷新");
//                mArrowView.animate().rotation(180);//显示箭头改为朝上
                break;
        }
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }


    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }


}
