package com.sesame.module_kotlin.android_developer.demo_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_android_coroutine.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineActivity : AppCompatActivity() {

    val loginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_coroutine)

        btnSend.setOnClickListener {
//            test()
//            loginViewModel.test()
            loginViewModel.test3()
        }

        btnCancel.setOnClickListener {
            loginViewModel.cleanUp()
            println("cancel")
        }
    }

    fun test() {
        println("start")

        GlobalScope.launch(Dispatchers.IO){
            println("before launch")
            delay(2000)
            println("after launch")
        }

//        viewModelScope.launch(Dispatchers.IO) {
//            println("before launch")
//            delay(2000)
//            println("after launch")
//        }
        println("end")
    }

}