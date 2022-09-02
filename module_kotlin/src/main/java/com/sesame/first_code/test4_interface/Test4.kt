package com.sesame.first_code.test4_interface

fun main() {
    val student = Student("coco", 18)
    doStudy(student)
}

private fun doStudy(study: Study){
    study.doHomework()
    study.readBooks()
}