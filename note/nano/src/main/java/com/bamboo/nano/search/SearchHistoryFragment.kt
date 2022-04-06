package com.bamboo.nano.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bamboo.nano.R
import com.bamboo.nano.search.history.SymbolsFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_search_history.*

class SearchHistoryFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): SearchHistoryFragment =
            SearchHistoryFragment()
    }

    private val tabTitles = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // tabLayout的使用
        tabTitles.add("外汇")
        tabTitles.add("商品")
        tabTitles.add("指数")

        // viewPager2的使用
        vpContent.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return tabTitles.size
            }

            override fun createFragment(position: Int): Fragment {
                return SymbolsFragment.newInstance(tabTitles[position])
            }
        }

        TabLayoutMediator(tabLayout, vpContent) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}