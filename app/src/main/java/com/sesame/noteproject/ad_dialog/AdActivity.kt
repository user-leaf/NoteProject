package com.sesame.noteproject.ad_dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.noteproject.R

class AdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad)

        AdsManager.getInstance(this).showAd()
    }

}