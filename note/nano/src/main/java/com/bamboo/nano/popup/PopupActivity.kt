package com.bamboo.nano.popup

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.R
import razerdp.basepopup.BasePopupWindow.GravityMode

class PopupActivity : AppCompatActivity() {
    var gravity = Gravity.BOTTOM
    var gravityMode = GravityMode.RELATIVE_TO_ANCHOR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val view = findViewById<View>(R.id.tvFund)

        view.setOnClickListener {
            MyPopupArrow(this)
                .setPopupGravity(gravityMode, gravity)
                .showPopupWindow(view)
        }
    }
}