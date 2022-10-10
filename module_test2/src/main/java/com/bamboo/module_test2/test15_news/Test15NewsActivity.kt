package com.bamboo.module_test2.test15_news

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R

class Test15NewsActivity : AppCompatActivity() {
    var isTwoPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test15_news)

        isTwoPane = findViewById<View>(R.id.newsContentLayout) != null
    }
}