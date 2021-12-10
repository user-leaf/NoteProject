package com.sesame.module_kotlin.android_developer.demo_coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class LoginViewModel : ViewModel() {

    /*
     1、launch()默认的调度程序是啥？// 如果您未将 Dispatcher 传递至 launch，则从 viewModelScope 启动的所有协程都会在主线程中运行。
     是不是一般不用指定，withContext需要指定
     2、async的返回值是await()?还是别的。job？
     3、withContext(Dispatchers.IO)用于线程调度，即切换线程。// Kotlin 协程使用调度程序确定哪些线程用于执行协程。

     */

    suspend fun login() {
        val TAG = "login"
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "login IO: " + Thread.currentThread().name)
        }

        viewModelScope.launch {
            Log.d(TAG, "login: default " + Thread.currentThread().name)
        }

        val async = viewModelScope.async {

        }
        async.await()

    }

    // 由于 withContext 本身就是一个挂起函数，因此函数 get 也是一个挂起函数。
    suspend fun get() {
        withContext(Dispatchers.IO) {

        }
    }

    fun test() {
        println("start")

//        GlobalScope.launch(Dispatchers.IO){
//            println("before launch")
//            delay(2000)
//            println("after launch")
//        }

        viewModelScope.launch(Dispatchers.IO) {
            println("before launch")
            delay(3000)
            println("after launch")
        }
        println("end")
    }

    suspend fun test2() {
        println("start")

        val async = viewModelScope.async(Dispatchers.IO) {
            println("before launch")
            delay(2000)
            println("after launch")
        }
        println("before await")
        async.await()
        println("end")
    }

    fun test2_thread() {
        println("@@start")
        Thread(Runnable {
            println("@@before")
//            Thread.sleep(2000)
            var i = 10000L;
            while (i >= 0) {
                println(i)
                i--
            }
            println("@@after")
        }).start()
        println("@@end")
    }

    fun cleanUp(){
        // Cancel the scope to cancel ongoing coroutines work
        viewModelScope.cancel()
    }

    fun test3(){
        println("start")
        println("所在线程1："+Thread.currentThread().name)
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            println("before launch")
            println("所在线程2："+Thread.currentThread().name)
            delay(2000)
            println("after launch")
        }
        println("所在线程3："+Thread.currentThread().name)
        println("end")
    }
}

suspend fun main() {
//    LoginViewModel().login()
//    LoginViewModel().test()
//    LoginViewModel().test2()
//    LoginViewModel().test2_thread()
    LoginViewModel().test3()
}