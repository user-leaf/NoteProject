package com.bamboo.nano.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    val keywordsLiveData = MutableLiveData<String>()

    val searchResultLiveData = MutableLiveData<List<SearchResultModel>>()

    val symbolsLiveData = MutableLiveData<List<String>>()

    fun changeKeywords(keywords: String){
        keywordsLiveData.value = keywords
    }

    fun loadData(keywords: String) {
        val list = mutableListOf<SearchResultModel>()
        for (index in 1..20) {
            list.add(SearchResultModel("$keywords - name$index", "code$index"))
        }
        searchResultLiveData.value = list
    }

    fun loadDataBySymbol() {
        val symbols = mutableListOf<String>()
        for (index in 0..30) {
            symbols.add("symbol-$index")
        }
        symbolsLiveData.value = symbols
    }
}