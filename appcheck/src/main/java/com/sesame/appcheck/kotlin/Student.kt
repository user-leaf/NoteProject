package com.sesame.appcheck.kotlin

class Student(name: String, age: Int) : Person(name, age), Study {

//    init {
//        println("sno is $sno")
//        println("grade is $grade")
//    }
//
//    fun showStu(){
//        println("sno is $sno")
//        println("$name is reading") //name是父类中的参数，用val修饰过了
//    }

    override fun readBooks() {
        println("$name is reading")
    }

}
