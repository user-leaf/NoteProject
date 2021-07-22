package com.sesame.module_kotlin.jetpack.viewmodel.sharedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareDataVm : ViewModel() {

    val progress: MutableLiveData<Int> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
    }


//    val progress: MutableLiveData<Int>
//        get() {
//            return data
//        }
//
//    private val data: MutableLiveData<Int> by lazy {
//        MutableLiveData<Int>().also {
//            loadData()
//        }
//    }
//
//    private fun loadData(){
//
//    }

    val seriesData: LiveData<Int>
        get() = data

    private val data: MutableLiveData<Int> = TODO()
}