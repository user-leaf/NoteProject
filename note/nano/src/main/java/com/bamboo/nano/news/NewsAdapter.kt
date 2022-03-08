package com.bamboo.nano.news

import com.bamboo.nano.R
import com.bamboo.nano.news.model.NewsInfo2
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class NewsAdapter : BaseQuickAdapter<NewsInfo2, BaseViewHolder>(R.layout.item_news) {

    override fun convert(helper: BaseViewHolder, item: NewsInfo2) {
        helper.setText(R.id.tvTitle, item.title)
    }
}