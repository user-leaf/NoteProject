package com.sesame.appcheck.kotlin

fun main(args: Array<String>) {
    val stu = Student("xiaohua", 7)
    study(null)


    val map = mapOf("aa" to 11, "bb" to 22, "cc" to 33)
    for ((name, age) in map) {
        println("$name == $age")
    }

}

fun study(stu: Student?) {
    stu?.let {
        it.readBooks()
        it.doHomework()
    } ?: print("空")
}