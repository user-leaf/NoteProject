package com.sesame.module_test.test_viewpager2

import androidx.viewpager2.widget.ViewPager2
import net.lucode.hackware.magicindicator.MagicIndicator

fun ViewPager2.bindIndicator(indicator: MagicIndicator, onPageChanged: ((Int) -> Unit)? = null) {
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            indicator.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            indicator.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            indicator.onPageSelected(position)
            onPageChanged?.invoke(position)
        }
    })
}