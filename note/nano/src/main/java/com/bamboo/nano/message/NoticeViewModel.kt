package com.bamboo.nano.message

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bamboo.nano.api.ApiMessage
import com.bamboo.nano.api.RetrofitUtils
import com.bamboo.nano.message.model.NoticeInfo
import kotlinx.coroutines.launch

class NoticeViewModel : ViewModel() {

    var page = 0

    val list = mutableListOf<NoticeInfo>()

    val noticeDataLiveData: MutableLiveData<List<NoticeInfo>> by lazy {
        MutableLiveData<List<NoticeInfo>>()
    }

    fun loadData(isNotice: Boolean, page: Int) {
        if (isNotice) {
            getNotice(page)
        } else {
            getMessage(page)
        }
    }

    private val api by lazy { RetrofitUtils.getRetrofit().create(ApiMessage::class.java) }

    private fun getNotice(page: Int) {
        viewModelScope.launch {
            val result = api.getNotification(page, 20).getValueWithCheck()
            if (page == 0) {
                list.clear()
            }
            list.addAll(result.resultList)
            noticeDataLiveData.value = list
            this@NoticeViewModel.page = page
        }
    }

    private fun getMessage(page: Int) {

    }
}