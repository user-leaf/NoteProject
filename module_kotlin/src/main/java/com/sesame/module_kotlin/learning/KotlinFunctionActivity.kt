package com.sesame.module_kotlin.learning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R

/*
Kotlin高阶函数
高阶函数：以另一个函数作为参数，或者返回值是函数 称为 高阶函数

*/
class KotlinFunctionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_function)

    }

}

fun main(args: Array<String>) {

    println("======不带参数的函数 作为形参=========")
    action(1) {
        println("第1种传递写法")
    }

    action(2, {
        println("第2种传递写法")
    })

    var method: () -> Unit = {
        println("第3种传递写法")
    }
    action(3, method)

    println("======带参数和返回值的函数 作为形参=========")
    action2(1) { it ->
        println("参数为${it}")
        return@action2 it == 100
    }

    println("======返回一个函数=========")
    var method3: (Int, Int) -> Int
    method3 = action3_1()
    println(method3.invoke(1, 2))
    method3 = action3_2()
    println(method3.invoke(1, 3))

}

/**
 * 2.1 不带参数的函数 作为形参
 */
fun action(first: Int, callback: () -> Unit) {
    callback.invoke()
}

/**
 * 2.2 带参数和返回值的函数 作为形参
 */
fun action2(first: Int, callback: (Int) -> Boolean) {
    if (callback(2)) {
        println("回调函数返回true")
    } else {
        println("回调函数返回false")
    }
}

/**
 * 2.3 返回一个函数
 */
fun action3_1(): (Int, Int) -> Int {
    return { i, j ->
        i + j
    }
}

fun action3_2(): (Int, Int) -> Int {
    return { i, j ->
        j - i
    }
}