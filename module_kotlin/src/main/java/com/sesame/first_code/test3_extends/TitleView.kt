package com.sesame.first_code.test3_extends

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.sesame.module_kotlin.R

class TitleView(context: Context, attr: AttributeSet? = null) :
    FrameLayout(context, attr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_fund_expandable, this)

        val ivLeft = findViewById<View>(R.id.ivLeft)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val ivRight = findViewById<View>(R.id.ivRight)

        val typedArray =
            context.obtainStyledAttributes(attr, R.styleable.TitleView)
        val showLeft = typedArray.getBoolean(R.styleable.TitleView_fev_showLeft, false)
        val showRight = typedArray.getBoolean(R.styleable.TitleView_fev_showRight, false)
        val title = typedArray.getString(R.styleable.TitleView_fev_title)
        typedArray.recycle()

        ivLeft.visibility = if (showLeft) VISIBLE else GONE
        ivRight.visibility = if (showRight) VISIBLE else GONE
        tvTitle.text = title
    }
}