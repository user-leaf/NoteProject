package com.sesame.first_code.test2_custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.layout_title.view.*

class TitleLayout(context: Context, attrs: AttributeSet?) : LinearLayoutCompat(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_title, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout)
        val showLeft = typedArray.getBoolean(R.styleable.TitleLayout_tl_showLeft, true)
        val showRight = typedArray.getBoolean(R.styleable.TitleLayout_tl_showRight, true)
        ivLeft.visibility = if (showLeft) VISIBLE else GONE
        ivRight.visibility = if (showRight) VISIBLE else GONE
        typedArray.recycle()
    }
}