package com.bamboo.nano.message

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoticeViewModel : ViewModel() {

    val data = MutableLiveData<List<NoticeInfo>>()

    fun loadData() {
        viewModelScope.launch {
            data.value = getInfoList()
        }
    }

    private fun getInfoList(): MutableList<NoticeInfo> {
        val list = mutableListOf<NoticeInfo>()
        list.add(NoticeInfo("张三", false))
        list.add(NoticeInfo("李四", false))
        list.add(NoticeInfo("王五", false))
        return list
    }
}