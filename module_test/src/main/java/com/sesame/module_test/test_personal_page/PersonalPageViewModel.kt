package com.sesame.module_test.test_personal_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PersonalPageViewModel : ViewModel() {

    private val repository by lazy {
        PersonalPageRepository(getNetworkService())
    }

    private val _userInfo = MutableLiveData<UserInfo>()

    val userInfo: LiveData<UserInfo>
        get() = _userInfo

    fun getInfo() {
        viewModelScope.launch {
            _userInfo.value = repository.getInfo()
        }
    }
}