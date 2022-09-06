package com.sesame.first_code.test5_operator


operator fun String.times(n: Int): String {
    val stringBuilder: StringBuilder = StringBuilder()
    repeat(n) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}