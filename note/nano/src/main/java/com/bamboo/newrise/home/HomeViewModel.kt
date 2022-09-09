package com.bamboo.newrise.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    val hotList = MutableLiveData<List<List<String>>>()

    fun loadData() {
        viewModelScope.launch {
            kotlin.runCatching {
                val result = mutableListOf<MutableList<String>>()
                val allData = getAllData().take(5)
                withContext(Dispatchers.IO) {  // why?
                    allData.forEach {
                        if ((result.lastOrNull()?.size ?: 3) == 3) {
                            result.add(mutableListOf<String>())
                        }
                        result.lastOrNull()?.add(it)
                    }
                    result  // 返回给runCatching的？
                }
            }.onSuccess {
                if (it.isNotEmpty()) {
                    hotList.value = it
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    private fun getAllData(): List<String> {
        val allList = mutableListOf<String>()
        repeat(50) {
            allList.add("品种$it")
        }
        return allList
    }
}