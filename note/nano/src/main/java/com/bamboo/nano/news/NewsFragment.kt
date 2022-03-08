package com.bamboo.nano.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_notice.*

class NewsFragment : Fragment() {

    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val newsAdapter = NewsAdapter()
        recyclerView.adapter = newsAdapter

        viewModel.newsListLiveData.observe(viewLifecycleOwner) {
            newsAdapter.setNewData(it)
        }
        refreshLayout.setEnableAutoLoadMore(true)
        refreshLayout.setOnRefreshListener {
            viewModel.loadData(0)
        }
        refreshLayout.setOnLoadMoreListener {
            viewModel.loadData(viewModel.page)
        }

        viewModel.loadData(0)

        viewModel.refreshState.observe(viewLifecycleOwner) {
            when (it) {
                RefreshState.CompleteRefreshing -> refreshLayout.finishRefresh()
                RefreshState.CompleteLoadingMore -> refreshLayout.finishLoadMore()
            }
        }
    }
}