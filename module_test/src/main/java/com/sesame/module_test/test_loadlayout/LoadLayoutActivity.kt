package com.sesame.module_test.test_loadlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_test_load.*

class LoadLayoutActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_load)

        println("@@@ act child count: ${loadLayout.childCount}")
    }
}