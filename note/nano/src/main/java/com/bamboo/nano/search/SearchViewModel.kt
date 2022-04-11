package com.bamboo.nano.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    // 为什么这么写？//dart语言里以下划线开头的是私有的。
    private val _keywordsLiveData = MutableLiveData<String>()
    val keywordsLiveData: LiveData<String>
        get() = _keywordsLiveData

    private val _searchResultLiveData = MutableLiveData<List<SearchResultModel>>()
    val searchResultLiveData: LiveData<List<SearchResultModel>>
        get() = _searchResultLiveData

    private val _symbolsLiveData = MutableLiveData<List<String>>()
    val symbolsLiveData: LiveData<List<String>>
        get() = _symbolsLiveData

    fun changeKeywords(keywords: String) {
        _keywordsLiveData.value = keywords
    }

    fun loadData(keywords: String) {
        val list = mutableListOf<SearchResultModel>()
        for (index in 1..20) {
            list.add(SearchResultModel("$keywords - name$index", "code$index"))
        }
        _searchResultLiveData.value = list
    }

    fun loadDataBySymbol() {
        val symbols = mutableListOf<String>()
        for (index in 0..30) {
            symbols.add("symbol-$index")
        }
        _symbolsLiveData.value = symbols
    }
}