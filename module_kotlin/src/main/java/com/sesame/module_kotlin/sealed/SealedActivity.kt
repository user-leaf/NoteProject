package com.sesame.module_kotlin.sealed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R

class SealedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed)


    }

    fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> "error is ${result.error.message}"
    }
}