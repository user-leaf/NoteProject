package com.sesame.noteproject.nulltest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sesame.noteproject.R
import kotlinx.android.synthetic.main.activity_null_test.*

class NullTestActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, NullTestActivity::class.java))
        }
    }

    var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_test)
        tvShow.setOnClickListener(this)
    }

    private fun test() {
//        if (tv != null){
//            tv.text = "123"
//        }
        tv?.text = "123" // 对变量做一次非空确认之后再调用方法，并且可以做到线程安全。Safe Call
        println("123123")
    }

    override fun onClick(p0: View?) {
//        test()
        println(test2(null))
    }

    fun test1(str: String) = str.toUpperCase()
    fun test2(str: String?) = str?.toUpperCase() ?: "abc"
    fun test3(str: String?) = str!!.toUpperCase()
}
