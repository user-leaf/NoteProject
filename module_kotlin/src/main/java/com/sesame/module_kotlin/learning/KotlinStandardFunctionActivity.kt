package com.sesame.module_kotlin.learning

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_kotlin_standard_function.*

/**
 * kotlin标准函数let、with、run、apply、also
 * https://blog.csdn.net/qq910689331/article/details/106327364
 */
class KotlinStandardFunctionActivity : AppCompatActivity() {
    val TAG = KotlinStandardFunctionActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_standard_function)

        /*
         let函数
         主要作用就是配合?.操作符进行辅助判空处理
         */
        btnLet.setOnClickListener {
            val list = ArrayList<String>()
            val result = list.let {
                it.add("aaa")
                it.add("bbb")
                it.add("ccc")
                "ok"
            }
            Log.d(TAG, "list: $list, result: $result")

            tv?.let {
                //text = ""
                it.text = "Kotlin let"
                it.textSize = 20f
                it.setOnClickListener {
                    Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
                }
            }

            testLet(null)
        }

        /*
        with函数
        常用反复调用同一个类的方法，可以省去重复书写这类。比如在 RecyclerView.ViewHolder中
        with(xxx){...}
         */
        btnWith.setOnClickListener {
            val myList = listOf<String>("aa", "bb", "cc", "dd")
            val builder = StringBuilder()
            val result = with(builder) {
                append("start--->\n")
                for (item in myList) {
                    append(item).append("\n")
                }
                append("<---end")
                toString()
            }
            println("@@@with函数 result: $result")
        }


        /*
        run函数
         跟with函数非常相似，只是稍微做了一些语法改动。（我）run函数在某个对象上调用xxx.run{...}
         */
        btnRun.setOnClickListener {
            val myList = listOf<String>("aa", "bb", "cc", "dd")
            val result = StringBuilder().run {
                append("start--->\n")
                for (item in myList) {
                    append(item).append("\n")
                }
                append("<---end")
                toString()
            }
            tv.run {
                text = ""
            }
            println("@@@run函数 result: $result")
        }

        /*
        apply函数
        apply函数和run函数极其类似，都要在某个对象上调用。
        但是apply函数无法指定返回值，而是会返回调用对象本身
        */
        btnApply.setOnClickListener {
            val myList = listOf<String>("aa", "bb", "cc", "dd")
            val result = StringBuilder().apply {
                append("start--->\n")
                for (item in myList) {
                    append(item).append("\n")
                }
                append("<---end")
            }
            println("@@@apply函数 result: ${result.toString()}")
        }

        /*
        also函数
        also可以理解为let的变种，他返回调用者本身。
         */
        btnAlso.setOnClickListener {

        }
    }

    private fun testLet(list: ArrayList<String>?) {
        val res = list.let {
            it?.add("aa")
            it?.add("bb")
        }
        Log.d(TAG, "runLet: $list, result: $res")
    }
}