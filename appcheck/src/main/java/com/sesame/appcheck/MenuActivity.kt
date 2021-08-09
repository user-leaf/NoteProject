package com.sesame.appcheck

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesame.appcheck.chapter6_broadcast.BroadcastActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    /*
       github上scwang的SmartRefreshLayout库是这样运用enum的
     */
    enum class MenuItem(var clazz: Class<*>) {
        BroadcastReceiver(BroadcastActivity::class.java),
        ;
    }

    var titles = mutableListOf<String>()
    private fun getAllTitles(): MutableList<String> {
        titles.clear()
        for (item: MenuItem in MenuItem.values()) {
            titles.add(item.name)
        }
        return titles
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initView()
    }

    private fun initView() {
        rvMenus.layoutManager = LinearLayoutManager(this)
        val adapter = MenuAdapter(getAllTitles())
        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(view.context, MenuItem.values()[position].clazz))
        }
        rvMenus.adapter = adapter
    }
}