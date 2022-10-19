package com.bamboo.nano.list.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import net.lucode.hackware.magicindicator.buildins.UIUtil

class ChartView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    init {
        background = context.resources.getDrawable(android.R.color.holo_blue_light)
        minimumHeight = UIUtil.dip2px(context, 80.0)
    }
}