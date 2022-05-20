package com.bamboo.nano.search_copy

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.bamboo.nano.R
import com.bamboo.nano.databinding.ActivitySearch2Binding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sesame.module_base.utils.FileUtils

class Search2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySearch2Binding
    private val fragments by lazy {
        mutableListOf<Fragment>()
    }

    private val viewModel by lazy {
        SearchViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearch2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llSelect.setOnClickListener {
            // TODO: pop
        }

        binding.etSearch.doAfterTextChanged {
            binding.ivClear.visibility = if (it.toString().isEmpty()) View.GONE else View.VISIBLE
            showFragment(if (it.toString().isEmpty()) 0 else 1)
            viewModel.changeKeyword(it.toString())
        }

        binding.ivClear.setOnClickListener {
            binding.etSearch.text.clear()
        }

        viewModel.loadData(this)

        viewModel.resultLiveData.observe(this) {
            if (it.isNotEmpty()) {
                println("@@@ value: ${it.get(0).name}, count: ${it.size}")
            }

        }

        // fragment切换
        showFragment(0)
    }

    private fun showFragment(index: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (fragments.isEmpty()) {
            fragments.add(HistoryFragment.newInstance())
            fragments.add(ResultFragment.newInstance())
            beginTransaction
                .add(R.id.fl_search_container, fragments[0], makeName(0)).hide(fragments[0])
                .add(R.id.fl_search_container, fragments[1], makeName(1)).hide(fragments[1])
        }
        for (fragment in fragments) {
            beginTransaction.hide(fragment)
        }
        beginTransaction
            .show(fragments[index])
            .commitAllowingStateLoss()
    }

    private fun makeName(index: Int): String {
        return "search-fragment-$index"
    }
}