package com.sesame.module_kotlin.`object`

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import com.sesame.module_kotlin.model.PostCodeModel

class ObjectDemoActivity : AppCompatActivity() {

    private lateinit var listener: OnMouseListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_object)

        // 匿名内部类？
        addMouseListener(object : OnMouseListener {
            override fun mouseClicked() {
                TODO("Not yet implemented")
            }

            override fun mouseEntered() {
                TODO("Not yet implemented")
            }
        })
    }

    fun addMouseListener(listener: OnMouseListener){
        this.listener = listener
    }
}

interface OnMouseListener{
    fun mouseClicked()
    fun mouseEntered()
}