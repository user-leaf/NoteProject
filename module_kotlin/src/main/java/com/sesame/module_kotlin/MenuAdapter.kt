package com.sesame.module_kotlin

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class MenuAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_menu_list, data) {
    override fun convert(helper: BaseViewHolder, item: String?) {
        helper.setText(R.id.tvTitle, item)
        helper.setBackgroundRes(
            R.id.tvTitle,
            if (helper.layoutPosition % 2 == 0) android.R.color.holo_blue_light else android.R.color.holo_orange_light
        )
    }
}