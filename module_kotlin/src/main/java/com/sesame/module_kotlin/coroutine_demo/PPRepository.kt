package com.sesame.module_kotlin.coroutine_demo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PPRepository {

    suspend fun makeInfoRequest(): PersonInfo {
        return withContext(Dispatchers.IO) {
            delay(1500)
            PersonInfo("https://img2.baidu.com/it/u=2285567582,1185119578&fm=26&fmt=auto", "张三")
        }
    }
}