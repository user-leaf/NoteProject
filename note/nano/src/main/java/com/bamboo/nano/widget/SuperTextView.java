package com.bamboo.nano.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bamboo.nano.R;

public class SuperTextView extends RelativeLayout {

    private Drawable leftIcon;
    private int leftIconSize;
    private int leftIconMarginLeft;
    private CharSequence leftText;
    private int leftTextSize;
    private int leftTextColor;
    private int leftTextMarginLeft;
    private Drawable rightIcon;
    private int rightIconSize;
    private int rightIconMarginRight;
    private CharSequence rightText;
    private int rightTextSize;
    private int rightTextColor;
    private int rightTextMarginRight;
    private int dividerHeight;
    private int dividerColor;
    private int dividerMarginLeft;

    public SuperTextView(Context context) {
        this(context, null);
    }

    public SuperTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SuperTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        initView();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SuperTextView);
        // TODO: 2022/7/4 try-catch
        try {
            leftIcon = array.getDrawable(R.styleable.SuperTextView_st_leftIcon);
            // TODO: 2022/7/4 getDimensionPixelSize
            leftIconSize = array.getDimensionPixelSize(R.styleable.SuperTextView_st_leftIconSize, -2); // 为什么定义成-2 // 因为match_parent是-1， wrap_content是-2
            leftIconMarginLeft = array.getDimensionPixelSize(R.styleable.SuperTextView_st_leftIconMarginLeft, dp2px(10)); // 为什么从外面设置margin为20dp才与这儿相等

            leftText = array.getText(R.styleable.SuperTextView_st_leftText);
            leftTextSize = array.getDimensionPixelSize(R.styleable.SuperTextView_st_leftTextSize, dp2px(15));
            leftTextColor = array.getColor(R.styleable.SuperTextView_st_leftTextColor, 0xff333333);
            leftTextMarginLeft = array.getDimensionPixelSize(R.styleable.SuperTextView_st_leftTextMarginLeft, dp2px(10));

            rightIcon = array.getDrawable(R.styleable.SuperTextView_st_rightIcon);
            rightIconSize = array.getDimensionPixelSize(R.styleable.SuperTextView_st_rightIconSize, -2);
            rightIconMarginRight = array.getDimensionPixelSize(R.styleable.SuperTextView_st_rightIconMarginRight, dp2px(10));

            rightText = array.getText(R.styleable.SuperTextView_st_rightText);
            rightTextSize = array.getDimensionPixelSize(R.styleable.SuperTextView_st_rightTextSize, dp2px(12));
            rightTextColor = array.getColor(R.styleable.SuperTextView_st_rightTextColor, 0xff999999);
            rightTextMarginRight = array.getDimensionPixelSize(R.styleable.SuperTextView_st_rightTextMarginRight, dp2px(10));

            dividerHeight = array.getDimensionPixelSize(R.styleable.SuperTextView_st_dividerHeight, 0);
            dividerColor = array.getColor(R.styleable.SuperTextView_st_dividerColor, 0xffe8e8e8);
            dividerMarginLeft = array.getDimensionPixelSize(R.styleable.SuperTextView_st_dividerMarginLeft, 0);

            array.recycle();
        } catch (Exception e) {

        }
    }

    private void initView() {
        initLeftIcon();
        initLeftText();
        initRightIcon();
        initRightText();
        initDivider();
    }

    private void initLeftIcon() {
        if (leftIcon == null) {
            return;
        }
        ImageView leftImageView = new ImageView(getContext());
        leftImageView.setId(R.id.leftImageView);
        leftImageView.setImageDrawable(leftIcon);
        // TODO: 2022/7/4
        LayoutParams params = new LayoutParams(leftIconSize, leftIconSize);
        params.addRule(CENTER_VERTICAL, TRUE);
        params.leftMargin = leftIconMarginLeft;
        addView(leftImageView, params);
    }

    private void initLeftText() {
        if (TextUtils.isEmpty(leftText)) {
            return;
        }
        TextView leftTextView = new TextView(getContext());
        leftTextView.setId(R.id.leftTextView);
        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
        leftTextView.setTextColor(leftTextColor);
        leftTextView.setText(leftText);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(CENTER_VERTICAL, TRUE);
        if (leftIcon != null) {
            params.addRule(RIGHT_OF, R.id.leftImageView);
        }
        params.leftMargin = leftTextMarginLeft;
        addView(leftTextView, params);
    }

    private void initRightIcon() {
        if (rightIcon == null) {
            return;
        }
        ImageView rightImageView = new ImageView(getContext());
        rightImageView.setId(R.id.rightImageView);
        rightImageView.setImageDrawable(rightIcon);
        LayoutParams params = new LayoutParams(rightIconSize, rightIconSize);
        params.addRule(CENTER_VERTICAL, TRUE);
        params.addRule(ALIGN_PARENT_RIGHT, TRUE);
        params.rightMargin = rightIconMarginRight;
        addView(rightImageView, params);
    }

    private void initRightText() {
        if (TextUtils.isEmpty(rightText)) {
            return;
        }
        TextView rightTextView = new TextView(getContext());
        rightTextView.setId(R.id.rightTextView);
        rightTextView.setText(rightText);
        rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
        rightTextView.setTextColor(rightTextColor);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(CENTER_VERTICAL, TRUE);
        if (rightIcon != null) {
            params.addRule(LEFT_OF, R.id.rightImageView);
        } else {
            params.addRule(ALIGN_PARENT_RIGHT, TRUE);
        }
        params.rightMargin = rightTextMarginRight;
        addView(rightTextView, params);
    }

    private void initDivider() {
        if (dividerHeight == 0) {
            return;
        }
        View view = new View(getContext());
        view.setBackgroundColor(dividerColor);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dividerHeight);
        params.leftMargin = dividerMarginLeft;
        params.addRule(ALIGN_PARENT_BOTTOM, TRUE);
        addView(view, params);
    }

    private int dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }
}
