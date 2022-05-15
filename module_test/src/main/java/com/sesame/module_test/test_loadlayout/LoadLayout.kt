package com.sesame.module_test.test_loadlayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.sesame.module_test.R

class LoadLayout(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_load, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        println("@@@ child count $childCount")
        if (childCount > 1) {
            val child = getChildAt(1)
            if (child != null) {
                println("@@@ childAt 1 is not null")
            }
        }
    }
}