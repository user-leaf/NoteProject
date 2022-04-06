package com.bamboo.nano.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private val searchViewModel by viewModels<SearchViewModel>()

    private val showFragmentManager by lazy {
        ShowFragmentManager(supportFragmentManager, R.id.fl_search_container) { index ->
            if (index == 0) {
                SearchHistoryFragment.newInstance()
            } else {
                SearchResultFragment.newInstance()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        tvSelect.setOnClickListener {
            Toast.makeText(this, "popup", Toast.LENGTH_SHORT).show()
        }

        et_search.doAfterTextChanged {
            iv_clear.visibility =
                if (et_search.text.toString().isEmpty()) View.GONE else View.VISIBLE
            showFragmentManager.showFragment(if (it.toString().isEmpty()) 0 else 1)
            searchViewModel.keywordsLiveData.value = it.toString()
        }

        iv_clear.setOnClickListener {
            et_search.text.clear()
        }

        showFragmentManager.showFragment(0)
    }
}