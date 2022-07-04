package com.bamboo.module_test2.test7_kotlin

fun main() {
    val list = listOf<String>("apple", "banana", "orange")
    println(list)

    val set = setOf<String>("apple", "banana", "orange")
    println(set)

    val map = mapOf<String, Int>("apple" to 1, "banana" to 2, "orange" to 3)
    for ((key, value) in map){
        println("$key -- $value")
    }

    val list2 = mutableListOf<String>()
    list2.add("aaaa")
    list2.add("bbbb")
    println(list2)

    val result = list.maxByOrNull { it.length }
    println(result)

    val setResult = set.maxByOrNull { it.length }
    println(setResult)

}