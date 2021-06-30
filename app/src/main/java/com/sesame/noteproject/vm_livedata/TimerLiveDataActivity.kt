package com.sesame.noteproject.vm_livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sesame.noteproject.R
import kotlinx.android.synthetic.main.activity_timer_live_data_kt.*

class TimerLiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_live_data_kt)

        val viewModel = ViewModelProviders.of(this).get(TimerWithLiveDataViewModel::class.java)
        viewModel.currentSecond.observe(this, Observer {
            tvShow.text = it.toString()
        })
        viewModel.startTiming()
    }
}
