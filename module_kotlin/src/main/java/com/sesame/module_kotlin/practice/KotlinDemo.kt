package com.sesame.module_kotlin.practice

/**
 * object关键字的使用场景
 * https://blog.csdn.net/xlh1191860939/article/details/79460601
 */
class KotlinDemo {
    companion object {
        var a: Int = 1
        fun m() {
            println("method()")
        }
    }
}

object RepositoryManager {
    const val PARAMS_A = "paramsA"
    fun method() {
        println("对象声明")
    }
}

interface AA {
    fun a()
}

interface BB {
    fun b()
}

fun main(args: Array<String>) {
    println(KotlinDemo.a)
    KotlinDemo.m()
    RepositoryManager.PARAMS_A
    RepositoryManager.method()

    var o = object : AA, BB {
        override fun a() {
            println("a()方法被调用")
        }

        override fun b() {
            println("b()方法被调用")
        }
    }
    o.a()
    o.b()
}