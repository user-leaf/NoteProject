package com.sesame.first_code.test4_interface

class Student(name:String, age:Int): Person(name, age), Study {
    override fun readBooks() {
        println("$name is reading.")
    }

}