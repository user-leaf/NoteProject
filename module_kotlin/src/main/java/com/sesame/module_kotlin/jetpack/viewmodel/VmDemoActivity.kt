package com.sesame.module_kotlin.jetpack.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_vm_demo.*

class VmDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vm_demo)

        // 【我】获取ViewModel实例
        val timerVm =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(TimerVm::class.java) // TimerVm2

        timerVm.setOnTimerCallback(object : OnTimerCallback {
            override fun onTimeChanged(currentTime: Int) {
                tvShow.text = currentTime.toString()
            }

        })

        timerVm.startTimer()
    }
}