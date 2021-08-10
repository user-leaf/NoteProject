package com.sesame.appcheck.chapter6_broadcast

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun main(args: Array<String>) {
    println(num1AndNum2(2, 3, ::plus))
    println(num1AndNum2(5, 3, ::minus))

    val num1 = 100
    val num2 = 80

    val result1 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result2 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }

    println("result1 = $result1")
    println("result2 = $result2")

    val fruits = listOf("aaa", "bbb", "ccc", "ddd", "eee")
    val result = StringBuilder().build {
        append("开始\n")
        for (fruit in fruits) {
            append(fruit).append("\n")
        }
        append("结束\n")
    }
    println(result.toString())

}
