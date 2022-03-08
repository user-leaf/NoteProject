package com.bamboo.nano.news.model

data class BaseNewsInfo2<T>(
    val success: Int,
    val value: T
) {
    fun isSuccessful(): Boolean {
        return success == 1
    }
}