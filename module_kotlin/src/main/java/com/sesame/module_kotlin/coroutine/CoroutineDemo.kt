package com.sesame.module_kotlin.coroutine

import kotlinx.coroutines.*

class CoroutineDemo {

}

fun main() {
    val singleThreadContext = newSingleThreadContext("aa")

    GlobalScope.launch(singleThreadContext) {
        // 在应用程序的生命周期内启动一个新的协程并继续
        delay(1000L)
        // 非阻塞的等待1秒钟
        println("【${Thread.currentThread().name}】World!")
    }
    println("【${Thread.currentThread().name}】Hello,") // main
    Thread.sleep(2000L) // 当前线程（main线程）阻塞2秒钟
    // 阻塞的等待2秒钟，因为协程的生命周期受应用程序生命周期限制，所以这里保证协程内部逻辑执行完

}