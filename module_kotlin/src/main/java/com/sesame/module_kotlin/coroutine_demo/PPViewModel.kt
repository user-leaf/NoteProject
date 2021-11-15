package com.sesame.module_kotlin.coroutine_demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PPViewModel : ViewModel() {
    private val repository = PPRepository()
    val personInfoLiveData = MutableLiveData<PersonInfo>()

    fun makeInfoRequest() {
        viewModelScope.launch {
            personInfoLiveData.value = repository.makeInfoRequest()
        }
    }
}