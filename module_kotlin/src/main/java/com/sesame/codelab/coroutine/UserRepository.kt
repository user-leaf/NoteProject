package com.sesame.codelab.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class UserRepository {
    suspend fun makeGetRequest(){
        withContext(Dispatchers.IO){ // 调度程序放在函数里，这样这个函数是主线程安全的。
            delay(10*1000)
            println("@@@ 网络请求")
        }
    }
}