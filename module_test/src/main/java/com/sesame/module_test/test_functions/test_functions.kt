package com.sesame.module_test.test_functions

import kotlin.random.Random
import com.sesame.module_test.utils.exchange as swap

fun main(args: Array<String>) {
    var aaa: String? = "I'm from China"
    val r = Random.nextInt(1, 100)
    println("随机数: $r")
    if (r % 2 == 0) {
        aaa = null
    }
    aaa?.let {
        println("aaa: $it")
    }

    var person: Person? = Person("Carson", 25)

    person?.run {
        println("My name is $name, I am $age years old.")
    }

    person.run {

    }

    repeat(5) {
        println("repeat $it")
    }

    run {

    }

    doSomething()

    val list = mutableListOf(1, 2, 3)

    list.exchange(1, 2)

    println("list: $list")

    println("sumIsEven: ${list.sumIsEven}")

    println("list swap: ${list.swap(1, 2)}")

//    val f1 = f1 {
//        "111"
//    }
//
//    println(f1)

    val result = f1(123){
        "111" + 123
    }
    println(result)
}

fun <T, R> f1(param: T, block: (T) -> R): R {
    return block(param)
}
