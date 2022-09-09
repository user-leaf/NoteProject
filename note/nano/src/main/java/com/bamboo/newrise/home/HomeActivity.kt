package com.bamboo.newrise.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContent, HomeFragment(), "homeFragment")
            .commit()
    }
}