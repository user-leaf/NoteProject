package com.bamboo.module_test2.test2_dataclass

fun main() {
    val a1 = CellPhone("huawei", 123.4)
    val a2 = CellPhone("huawei", 123.4)
    println(a1.toString())
    println(a1 == a2)

    val p1 = Person("zhangsan", 18)
    val p2 = Person("zhangsan", 18)
    println(p1.toString())
    println(p1 == p2)
}