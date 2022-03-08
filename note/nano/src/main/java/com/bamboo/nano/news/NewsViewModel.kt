package com.bamboo.nano.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamboo.nano.api.RetrofitUtils
import com.bamboo.nano.news.model.NewsInfo2
import kotlinx.coroutines.launch
import kotlin.random.Random

class NewsViewModel : ViewModel() {

    var page = 0

    val newsListLiveData = MutableLiveData<List<NewsInfo2>>()

    private val apiNews = RetrofitUtils.getRetrofit().create(ApiNews::class.java)

    private val news: MutableList<NewsInfo2> by lazy {
        mutableListOf()
    }

    val refreshState: MutableLiveData<RefreshState> by lazy {
        MutableLiveData<RefreshState>()
    }

    fun loadData(page: Int) {
        viewModelScope.launch {
//            val apiNews = apiNews.getEconomicNews("CN", 10, page)
//            if (apiNews.isSuccessful()) {
            if (page == 0) {
                news.clear()
            }

            val list = mutableListOf<NewsInfo2>()
            val random = Random.nextInt(10)
            val title = 'A' + random
            for (item in 0..10) {
                list.add(NewsInfo2("$title - $item"))
            }
            news.addAll(list)

            newsListLiveData.value = news
            this@NewsViewModel.page++
            refreshState.value = RefreshState.CompleteLoadingMore
            refreshState.value = RefreshState.CompleteRefreshing
//            }
        }
    }
}