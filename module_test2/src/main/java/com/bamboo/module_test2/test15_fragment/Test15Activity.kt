package com.bamboo.module_test2.test15_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R

class Test15Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test15)

//        Test15Fragment.newInstance("aaa","bbb")

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, Test15Fragment.newInstance("111", "222"), "111222")
            .commit()
    }
}