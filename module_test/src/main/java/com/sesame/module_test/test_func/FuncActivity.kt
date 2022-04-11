package com.sesame.module_test.test_func

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_test.R

class FuncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_test_func)

        val func: (String) -> Int = { input ->
            input.length
        }

        val length = func("Hello world.")
        println(length)

        val length2 = stringMapper("hello") {
            it.length
        }
        println(length2)
    }

    private fun stringMapper(str: String, mapper: (String) -> Int): Int {
        return mapper(str)
    }
}