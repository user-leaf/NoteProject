package com.bamboo.module_test2.test4_kotlin_check

data class BaseModel<T>(
    val success: Boolean = false, val value: T? = null
)
