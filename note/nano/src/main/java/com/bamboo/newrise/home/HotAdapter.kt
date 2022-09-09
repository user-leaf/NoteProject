package com.bamboo.newrise.home

import com.bamboo.nano.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class HotAdapter(data: List<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_hot, data) {
    override fun convert(helper: BaseViewHolder, item: String?) {
        helper.setText(R.id.tvTitle, item)
    }
}