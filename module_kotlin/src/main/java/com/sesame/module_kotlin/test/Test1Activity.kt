package com.sesame.module_kotlin.test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.databinding.ActivityTest1Binding
import kotlinx.android.synthetic.main.activity_test1.*

class Test1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTest1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTest1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        tv_name.text = "hahaha"
        tv_name.setOnClickListener {
            Toast.makeText(this, "hahaha", Toast.LENGTH_SHORT).show()
        }
    }
}