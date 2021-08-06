package com.sesame.appcheck.chapter6_broadcast

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.appcheck.R
import kotlinx.android.synthetic.main.activity_broadcast.*

class BroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        btnSend.setOnClickListener {
            val intent = Intent("com.sesame.appcheck.broadcast.MY_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)

        }
    }
}