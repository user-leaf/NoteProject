package com.sesame.codelab.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_codelab_coroutine.*
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {

    val viewModel by lazy {
        CoroutineViewModel(UserRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codelab_coroutine)

        btnGetData.setOnClickListener {
//            GlobalScope.launch {
                viewModel.fetchDocs()
//            }

            println("TAG Over")
        }
    }
}