package com.sesame.module_kotlin.android_developer

import java.math.BigDecimal

class KotlinClass {
    companion object {
        @JvmField
        var name: String = "hahaha"

        @JvmField
        val BIG_INTEGER_ONE = BigDecimal.ONE

        const val INTERER_ONE = 1

        @JvmStatic
        fun doWork(name2: String, num2: Int) {
            println("kotlin class doWork() ${name2} -- $num2")
        }
    }
}