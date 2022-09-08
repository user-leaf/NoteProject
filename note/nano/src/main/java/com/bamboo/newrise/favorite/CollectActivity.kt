package com.bamboo.newrise.favorite

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.activity_collect.*
import kotlinx.android.synthetic.main.item_collect.view.*

/**
 * 自选
 */
class CollectActivity : AppCompatActivity() {

    private val names = mutableListOf("品种1", "品种2", "品种3", "品种4", "品种5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collect)

        addItems(names)
    }

    private fun addItems(names: MutableList<String>) {
        names.forEach {
            val itemView =
                LayoutInflater.from(this).inflate(R.layout.item_collect, llCollect, false)
            itemView.chbCollect.text = it
            llCollect.addView(itemView)
        }
    }
}
