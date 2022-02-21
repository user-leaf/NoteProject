package com.sesame.codelab

import android.content.Context
import androidx.collection.arraySetOf
import androidx.core.content.edit

fun main(args: Array<String>) {


    fun spEdit(context: Context) {
        val sharedPreferences = context.getSharedPreferences("", Context.MODE_PRIVATE)
        sharedPreferences.edit { putBoolean("key", true) }
    }

    val list = arrayListOf(1, 2, 3) + arrayListOf(4, 5, 6)
    val newList = list + 7+8
    println(newList)
}