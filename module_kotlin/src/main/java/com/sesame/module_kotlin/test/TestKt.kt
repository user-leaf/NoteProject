package com.sesame.module_kotlin.test

fun main() {
    val map = hashMapOf("key1" to "stu1", "key2" to "stu2")
    map.forEach{ (k, v) ->
        println("$k - $v")
    }

    for ((k, v) in map){
        println("$k -- $v")
    }
}