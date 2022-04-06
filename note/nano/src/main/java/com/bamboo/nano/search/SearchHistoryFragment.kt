package com.bamboo.nano.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bamboo.nano.R

class SearchHistoryFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): SearchHistoryFragment =
            SearchHistoryFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_history, container, false)
    }
}