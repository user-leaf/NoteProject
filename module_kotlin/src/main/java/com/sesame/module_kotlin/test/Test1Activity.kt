package com.sesame.module_kotlin.test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R

class Test1Activity : AppCompatActivity() {

    val v1: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1)
    }
}