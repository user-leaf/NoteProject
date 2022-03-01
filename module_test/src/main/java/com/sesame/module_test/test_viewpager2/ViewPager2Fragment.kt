package com.sesame.module_test.test_viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.fragment_test_view_pager2.*

class ViewPager2Fragment : Fragment() {

    companion object {
        fun getInstance(param: String): ViewPager2Fragment {
            val fragment = ViewPager2Fragment()
            val bundle = Bundle()
            bundle.putString("param", param)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test_view_pager2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        tvTitle.text = arguments?.getString("param") ?: "title"

        val titles = mutableListOf<String>("子标题1", "子标题2", "子标题3")
        val fragments = mutableListOf<DetailsFragment>()
        fragments.add(DetailsFragment())
        fragments.add(DetailsFragment())
        fragments.add(DetailsFragment())

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return titles.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        pager2.adapter = adapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, pager2) { tab, position ->
            tab.text = titles[position]
        }.attach()

        btnAddPage.setOnClickListener {
            titles.add("新标题")
            fragments.add(DetailsFragment())
            adapter.notifyDataSetChanged()
        }
    }
}