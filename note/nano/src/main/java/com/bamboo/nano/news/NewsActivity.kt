package com.bamboo.nano.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.R

class NewsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        supportFragmentManager.beginTransaction().add(R.id.flContent, NewsFragment(), "news").commit()

    }
}