package com.sesame.codelab.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun fetchDocs(){
        viewModelScope.launch {
            val a = getParam1()
            val b = getParam2()
            show(a, b)
        }
    }

    private suspend fun getParam1(): String{
        println("TAG getParam1: 1")
        withContext(Dispatchers.IO){
            println("TAG getParam1: 2")
            delay(2000)
            println("TAG getParam1: 3")
        }
        println("TAG getParam1: 4")
        return "haha"
    }

    private suspend fun getParam2(): String{
        println("TAG getParam2: 1")
        withContext(Dispatchers.IO){
            println("TAG getParam2: 2")
            delay(2000)
            println("TAG getParam2: 3")
            "param2"
        }
        println("TAG getParam2: 4")
        return "hehe"
    }

    private fun show(p1: String, p2: String){
        println("@@@TAG show: $p1, $p2")
    }
}