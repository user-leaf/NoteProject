package com.sesame.module_test.test_flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.random.Random

class FlowViewModel : ViewModel() {

    val valueFlow = MutableStateFlow<String?>(null)

    val simpleFlow = flow {
        for (i in 1..5) {
            delay(1000)
            emit(i)
        }
    }

    fun loadData() {
        viewModelScope.launch {
            for (i in 1..10) {
                delay(100)
                valueFlow.emit("" + i)
            }

            val v = Random.nextInt(100)
            valueFlow.emit("haha$v")
        }
    }

    fun getUser() {
//        RetrofitClient.getApi<Api>().getUser("user-leaf").enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                println(response.body())
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                println(t.message)
//            }
//        })

        viewModelScope.launch {
            try {
                val user = RetrofitClient.getApi<Api>().getUser("user-leaf")
                println(user)
            } catch (t: Throwable) {
                println(t.message)
            }
        }
    }
}