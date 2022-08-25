package com.sesame.first_code.test1_standard_function

fun main() {
    val list = listOf<String>("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)


    val result_run = StringBuilder().run {
        toString()
    }
    println(result_run)

    StringBuilder().apply {

    }
}
