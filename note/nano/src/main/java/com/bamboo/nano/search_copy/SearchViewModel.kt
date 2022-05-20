package com.bamboo.nano.search_copy

import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sesame.module_base.utils.FileUtils

class SearchViewModel : ViewModel() {
    private val _instruments = mutableListOf<InstrumentMapping>()
    val resultLiveData = MutableLiveData<List<InstrumentMapping>>()

    private var type = "all"
    private var keyword: String? = null

    fun loadData(context: Context) {
        val json = FileUtils.getJson(context, "data.json")
        val type = object : TypeToken<List<InstrumentMapping>>() {}.type
        _instruments.clear()
        _instruments.addAll(Gson().fromJson(json, type))
        updateData()
    }

    fun changeKeyword(keyword: String?) {
        this.keyword = keyword
        updateData()
    }

    fun changeType(type: String) {
        this.type = type
        updateData()
    }

    private fun updateData(){
        resultLiveData.value = _instruments.filter {
            if (TextUtils.isEmpty(this.keyword)) {
                true
            } else {
                it.symbol.contains(keyword!!, true)
            }
        }
    }
}

