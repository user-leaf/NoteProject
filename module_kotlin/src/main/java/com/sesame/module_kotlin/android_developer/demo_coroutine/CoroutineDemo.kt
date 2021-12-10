package com.sesame.module_kotlin.android_developer.demo_coroutine

import kotlinx.coroutines.*

class CoroutineDemo {

}

suspend fun main() {
    fetchDocs()
//    fetchTwoDocs()
//    fetchTwoDocs2()

    val scope = CoroutineScope(Job() + Dispatchers.Main)
    scope.launch {

    }
}

suspend fun fetchDocs() {
    val result = get("www.baidu.com")
    println(result)
}

suspend fun get(url: String): String {
    return withContext(Dispatchers.IO) {
        println("before delay")
        delay(2000)
        println("after delay")
        url
    }
}

suspend fun fetchTwoDocs() {
    coroutineScope {
        val deferred1 = async { get("url1:www.baidu.com") }
        val deferred2 = async { get("url2:www.google.com") }
        println("async")
        deferred1.await()
        deferred2.await()
        println("await")
    }
}

suspend fun fetchTwoDocs2() {
    coroutineScope {
        println("before list")
        val defenders = listOf(
            async { get("1") },
            async { get("2") }
        )
        println("after list")
        defenders.awaitAll()
        println("over")
    }
}
