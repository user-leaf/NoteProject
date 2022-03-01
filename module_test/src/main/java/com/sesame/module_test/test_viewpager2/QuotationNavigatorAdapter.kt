package com.sesame.module_test.test_viewpager2

import android.content.Context
import androidx.core.content.ContextCompat
import com.sesame.module_test.R
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator

class QuotationNavigatorAdapter(
    private val titles: List<String>,
    private val showIndicator: Boolean = true,
    private val onChangePos: (Int) -> Unit,
) : CommonNavigatorAdapter() {
    override fun getCount(): Int {
        return titles.size
    }

    override fun getTitleView(context: Context, index: Int): IPagerTitleView {
        val simplePagerTitleView = CustomTitleView(context)
        simplePagerTitleView.normalColor = ContextCompat.getColor(context, R.color.text_color_57)
        simplePagerTitleView.selectedColor = ContextCompat.getColor(context, R.color.text_color_03)
        simplePagerTitleView.text = titles[index]
        simplePagerTitleView.setOnClickListener {
            onChangePos(index)
        }
        return simplePagerTitleView
    }

    override fun getIndicator(context: Context): IPagerIndicator? {
        if (!showIndicator) return null
        val linePagerIndicator = LinePagerIndicator(context)
        linePagerIndicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
        linePagerIndicator.xOffset = UIUtils.dip2px(6f).toFloat()
        linePagerIndicator.setColors(ContextCompat.getColor(context, R.color.text_color_33))
        return linePagerIndicator
    }
}