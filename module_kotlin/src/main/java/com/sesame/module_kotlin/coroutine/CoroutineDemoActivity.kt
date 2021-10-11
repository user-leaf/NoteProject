package com.sesame.module_kotlin.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_demo_coroutine.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// https://www.jianshu.com/p/76d2f47b900d
class CoroutineDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_coroutine)

        btnRun.setOnClickListener {

            /*
            协程里使用 suspend 关键字修饰方法，
            即该方法可以被协程挂起，没用suspend修饰的方法不能参与协程任务。
            */
            GlobalScope.launch {
                val token = requestToken()
                val post = createPost(token)
                processPost(post)
            }
        }
    }

    private fun processPost(post: String) {
        println("post: $post")
    }

    private suspend fun createPost(token: String): String {
        delay(700)
        return "post token $token"
    }

    private suspend fun requestToken(): String {
        delay(800)
        return "1234"
    }
}