package com.sesame.noteproject.test_company;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.sesame.noteproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainTitle extends LinearLayout {

    @BindView(R.id.ivLeft)
    ImageView mIvLeft;
    @BindView(R.id.tvTitle)
    TextView mTvTitle;
    @BindView(R.id.ivRight)
    ImageView mIvRight;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    private View mContentView;
    private Unbinder bind;

    public MainTitle(Context context) {
        this(context, null);
    }

    public MainTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public Toolbar getToolBar() {
        return mToolBar;
    }

    private void initView(Context context) {
        mContentView = LayoutInflater.from(context).inflate(R.layout.view_main_title, this);
        bind = ButterKnife.bind(mContentView);
    }

    @OnClick({R.id.ivLeft, R.id.tvTitle, R.id.ivRight, R.id.toolBar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                Toast.makeText(getContext(), "left", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvTitle:
                Toast.makeText(getContext(), "title", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivRight:
                Toast.makeText(getContext(), "right", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolBar:
                break;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mContentView != null) {
            bind.unbind();
        }
    }
}
