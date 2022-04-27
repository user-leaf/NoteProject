package com.sesame.module_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sesame.module_test.databinding.ActivityTestRvBinding
import kotlinx.android.synthetic.main.activity_test_rv.*

class RvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_test_rv)

        val binding = ActivityTestRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvContent.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val data = mutableListOf<String>()

        val adapter =
            object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_test_tv, data) {

                override fun convert(helper: BaseViewHolder, item: String?) {
                    helper.setText(R.id.tvTitle, item)
                }

            }
        rvContent.adapter = adapter

        for (i in 0..20) {
            data.add("data:$i")
        }

        adapter.notifyDataSetChanged()

        rvContent.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

    }
}
