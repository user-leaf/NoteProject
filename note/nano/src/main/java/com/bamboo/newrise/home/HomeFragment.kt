package com.bamboo.newrise.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHot()
        viewModel.loadData()
    }

    private fun initHot() {
        viewModel.hotList.observe(viewLifecycleOwner){
            val hotAdapter = HotPagerAdapter(it, childFragmentManager, lifecycle)
            viewPager2.adapter = hotAdapter
        }
    }
}