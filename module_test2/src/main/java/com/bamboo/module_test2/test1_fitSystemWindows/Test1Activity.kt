package com.bamboo.module_test2.test1_fitSystemWindows

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_test1_fitsystemwindows.*

class Test1Activity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test1_fitsystemwindows)
//        window.statusBarColor = Color.TRANSPARENT
    }
}