package com.sesame.module_kotlin.coroutine

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import com.sesame.module_kotlin.model.BasePageInfo
import com.sesame.module_kotlin.model.BaseRequest
import com.sesame.module_kotlin.model.PostCodeModel
import com.sesame.module_kotlin.net.ApiService
import com.sesame.module_kotlin.net.RetrofitUtils
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        /*
        Kotlin提供了协程相关的专用函数，提供了大量高阶函数。Kotlin中GlobalScope类提供了几个协程构造函数。
         */

//        initFun()
//        initFun2()


        queryPostCode()
    }

    private fun queryPostCode() {
        val apiService = RetrofitUtils.getRetrofit("").create(ApiService::class.java)

        btnCode.setOnClickListener {
            apiService.getPostCode("276400", "64df29265bcad4df38525600664d3419")
                .enqueue(object : Callback<BaseRequest<BasePageInfo<PostCodeModel>>> {
                    override fun onResponse(
                        call: Call<BaseRequest<BasePageInfo<PostCodeModel>>>,
                        response: Response<BaseRequest<BasePageInfo<PostCodeModel>>>
                    ) {
                        if (response.isSuccessful) {
                            val model = response.body()
                            tvShow.text = model!!.result.list[0].city
                        }
                    }

                    override fun onFailure(call: Call<BaseRequest<BasePageInfo<PostCodeModel>>>, t: Throwable) {
                        tvShow.text = t.message
                    }

                })
        }
    }

    private fun initFun2() {

        GlobalScope.launch(Dispatchers.IO) {
            val name = getMessageFromNetwork()
            showMessage(name)

            val name1 = getMessageFromNetwork()
            showMessage(name1)

            val name2 = getMessageFromNetwork()
            showMessage(name2)

        }
    }

    private fun showMessage(message: String) {
        tvShow.text = tvShow.text.toString() + message
    }

    private suspend fun getMessageFromNetwork(): String {
        var name = ""
        withContext(Dispatchers.IO) {
            for (i in 1..100000L) {
                // 模拟耗时操作 how

            }
            name = "bbb" + System.currentTimeMillis() + "\n"
        }
        return name
    }

    private fun initFun() {

        val job = GlobalScope.launch(context = Dispatchers.IO, start = CoroutineStart.LAZY) {
            Log.d("AA", "AA协程开始运行，时间：" + System.currentTimeMillis())
        }

        btnStart.setOnClickListener {
            job.start()
        }

        GlobalScope.launch {
            /*
            async的特点是不会阻塞当前线程，但会阻塞所在协程，也就是挂起
             */
            val deferred = GlobalScope.async {
                delay(1000L)
                Log.d("CCC", "This is async")
                return@async "kkk"
            }

            Log.d("CCC", "协程 other start")
            val result = deferred.await()
            Log.d("CCC", "async result is $result")
            Log.d("CCC", "协程 other end")
        }

//        Log.d("CC", "主线程位于协程之后的代码执行，时间：${System.currentTimeMillis()}")

        /*
        GlobalScope类提供的协程构造函数：launch/async/withContext/runBlocking

        上下文：多数情况下不需要自己去实现上下文，只需要使用现成的就好。
        调度器Dispatchers.Main/IO/Default/Unconfined
        作用之一：线程切换

        4种启动模式：default/lazy/atomic/undispatched
        ATOMIC启动模式,立即等待被调度执行,并且开始执行前无法被取消,直到执行完毕或者遇到第一个挂起点。
         */
    }
}
