package com.sesame.module_kotlin.jetpack.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_kotlin.R
import com.sesame.module_kotlin.jetpack.lifecycle.page.MyLocationListener
import com.sesame.module_kotlin.jetpack.lifecycle.page.OnLocationChangedCallback
import com.sesame.module_kotlin.jetpack.lifecycle.service.MyService
import kotlinx.android.synthetic.main.activity_lifecycle.*

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        val listener = MyLocationListener()
        listener.setOnLocationChangedCallback(object : OnLocationChangedCallback {
            override fun onChange() {

            }
        })
        // 将观察者与被观察者绑定
        lifecycle.addObserver(listener)

        btnStartService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }

        btnStopService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
    }
}
