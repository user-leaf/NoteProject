package com.sesame.module_test.test_gson

import com.google.gson.Gson

fun main(args: Array<String>) {
    val gson = Gson()
    val json = "{\n" +
            "  \"name\": null,\n" +
            "  \"age\": null\n" +
            "}"
    val person = gson.fromJson(json, Person::class.java)
    println(person)
    println(person.name)
    println(person.age)
}