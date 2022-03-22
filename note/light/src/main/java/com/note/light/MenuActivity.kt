package com.note.light

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.note.light.chapter1.Chapter1Activity
import com.note.light.chapter2.Chapter2Activity
import com.note.light.chapter2.TabLayoutActivity
import com.note.light.chapter3_view.AnimatorDemoActivity
import com.note.light.chapter3_view.ViewMoveActivity
import com.note.light.chapter8_rxjava.RxJavaDemoActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    enum class MenuItem(var clazz: Class<*>) {
        第1章_Android新特性(Chapter1Activity::class.java),
        第2章_MaterialDesign(Chapter2Activity::class.java),
        第2章_TabLayout的使用(TabLayoutActivity::class.java),
        第3章_View体系(ViewMoveActivity::class.java),
        第3章_属性动画(AnimatorDemoActivity::class.java),
        第8章_RxJava(RxJavaDemoActivity::class.java),
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