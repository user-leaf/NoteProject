package com.sesame.codelab.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val persons: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}