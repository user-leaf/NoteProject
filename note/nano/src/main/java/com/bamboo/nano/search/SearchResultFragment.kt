package com.bamboo.nano.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : Fragment() {

    private val searchViewModel by activityViewModels<SearchViewModel>()
    private val adapter by lazy {
        SearchAdapter()
    }

    companion object {
        @JvmStatic
        fun newInstance(): SearchResultFragment {
            return SearchResultFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        searchViewModel.searchResultLiveData.observe(viewLifecycleOwner) {
            adapter.replaceData(it)
        }
        searchViewModel.keywordsLiveData.observe(viewLifecycleOwner) {
            searchViewModel.loadData(it)
        }
    }
}