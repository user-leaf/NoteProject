package com.bamboo.nano.search.history

import com.bamboo.nano.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class SymbolsAdapter :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_search_result) {
    override fun convert(helper: BaseViewHolder, item: String) {
        helper.setText(R.id.tvTitle, item)
    }
}