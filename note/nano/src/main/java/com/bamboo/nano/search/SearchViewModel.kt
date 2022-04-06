package com.bamboo.nano.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val keywordsLiveData = MutableLiveData<String>()

    val searchResultLiveData = MutableLiveData<List<SearchResultModel>>()

    fun loadData(keywords: String) {
        val list = mutableListOf<SearchResultModel>()
        for (index in 1..20) {
            list.add(SearchResultModel("$keywords - name$index", "code$index"))
        }
        searchResultLiveData.value = list
    }
}