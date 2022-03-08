package com.sesame.module_test.test_functions

fun doSomething() {
    println("do something")
}

//声明扩展函数：
fun <T : Any?> MutableList<T>?.exchange(fromIndex: Int, toIndex: Int) {
    if (null == this) {
        return
    }
    val temp = this[fromIndex]
    this[fromIndex] = this[toIndex]
    this[toIndex] = temp
}

fun <T: Any?> MutableList<T>?.swap(fromIndex: Int, toIndex: Int){

}

//声明扩展属性：
val MutableList<Int>?.sumIsEven
    get() = if (null == this) {
        false
    } else {
        this.sum() % 2 == 0
    }