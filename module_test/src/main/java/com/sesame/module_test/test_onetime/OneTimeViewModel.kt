package com.sesame.module_test.test_onetime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sesame.module_test.utils.OneTimeLiveData

class OneTimeViewModel: ViewModel(){
    private var v1 = 1
//    val message1: MutableLiveData<String> = MutableLiveData("")
    val message1 = OneTimeLiveData<String>()
    fun showMessage(){
        message1.setOneTimeValue("aaa:$v1")
        v1++
    }
}