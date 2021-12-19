package com.note.light

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.note.light.chapter1.Chapter1Activity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    enum class MenuItem(var clazz: Class<*>) {
        第1章_Android新特性(Chapter1Activity::class.java),
        ;

        companion object {
            var titles = mutableListOf<String>()
            fun getAllTitles(): MutableList<String> {
                titles.clear()
                for (item: MenuItem in values()) {
                    titles.add(item.name)
                }
                return titles
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initView()
    }

    private fun initView() {
        rvMenus.layoutManager = LinearLayoutManager(this)
        val adapter = MenuAdapter(MenuItem.getAllTitles())
        adapter.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(view.context, MenuItem.values()[position].clazz))
        }
        rvMenus.adapter = adapter
    }
}