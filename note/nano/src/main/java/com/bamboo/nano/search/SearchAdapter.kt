package com.bamboo.nano.search

import com.bamboo.nano.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class SearchAdapter :
    BaseQuickAdapter<SearchResultModel, BaseViewHolder>(R.layout.item_search_result) {
    override fun convert(helper: BaseViewHolder, item: SearchResultModel) {
        helper.setText(R.id.tvTitle, item.name + " - " + item.code)
    }
}