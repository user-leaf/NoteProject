package com.sesame.codelab.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sesame.codelab.User

class MyViewModel : ViewModel() {
    val persons: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val userLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
}