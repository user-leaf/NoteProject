package com.bamboo.nano.list.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.widget_quotation.view.*

class QuotationView : RelativeLayout {

    private var title: String? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        LayoutInflater.from(context).inflate(R.layout.widget_quotation, this)
    }

    fun setTitle(name: String) {
        tvName.text = name
    }
}