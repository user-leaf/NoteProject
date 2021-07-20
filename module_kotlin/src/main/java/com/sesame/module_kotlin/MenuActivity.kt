package com.sesame.module_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sesame.module_kotlin.coroutine.CoroutineActivity
import com.sesame.module_kotlin.jetpack.lifecycle.LifecycleActivity
import com.sesame.module_kotlin.jetpack.viewmodel.VmDemoActivity
import com.sesame.module_kotlin.learning.KotlinStandardFunctionActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    enum class MenuItem(var clazz: Class<*>) {
        Kotlin(KotlinStandardFunctionActivity::class.java),
        Coroutine(CoroutineActivity::class.java),
        Lifecycle(LifecycleActivity::class.java),
        ViewModel(VmDemoActivity::class.java),
        ;

        companion object {
            var titles = mutableListOf<String>()
            fun getAllTitles(): MutableList<String> {
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