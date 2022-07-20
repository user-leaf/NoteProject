package com.bamboo.module_test2.test13_coroutine

import kotlinx.coroutines.*

fun main() {
//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//        delay(1500)
//        // 还没来得及运行，应用程序就已经结束了。
//        println("codes run in coroutine scope finished")
//    }
//    Thread.sleep(1000)

//    runBlocking {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine scope finished")
//    }

    val start = System.currentTimeMillis()
    runBlocking {
        for (i in 0..100000) {
            launch {
                println(".")
            }
        }
    }
    println(System.currentTimeMillis()-start)

}