package com.bamboo.newrise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.R
import com.bamboo.newrise.favorite.CollectActivity
import com.bamboo.newrise.home.HomeActivity
import kotlinx.android.synthetic.main.activity_newrise.*

class NewriseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newrise)

        btnCollect.setOnClickListener {
            startActivity(Intent(this, CollectActivity::class.java))
        }

        btnHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}