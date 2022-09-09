package com.bamboo.newrise.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HotPagerAdapter(
    val list: List<List<String>>,
    childFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) :
    FragmentStateAdapter(childFragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return HotFragment(list[position])
    }
}