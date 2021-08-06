package com.sesame.appcheck.kotlin

open class Person(val name:String, val age: Int) {

    fun show(){
        println("name: $name")
        println("age: $age")
    }
}