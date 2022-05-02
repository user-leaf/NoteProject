package com.sesame.module_test.study_bottom_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sesame.module_test.databinding.FragmentVpHomeBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VpHomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentVpHomeBinding

    private val fragments = mutableListOf<Fragment>()

    private val titles = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVpHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VpHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO:  滑到最右，再往回滑动之后，不明白为什么会再次执行。
        initData()
        val adapter = MyFragmentStateVpTitleAdapter(childFragmentManager, fragments, titles)
        binding.vpHome.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.vpHome)
    }

    private fun initData() {
        fragments.add(VpContentFragment.newInstance("title1", ""))
        fragments.add(VpContentFragment.newInstance("title2", ""))
        fragments.add(VpContentFragment.newInstance("title3", ""))
        fragments.add(VpContentFragment.newInstance("title4", ""))
        fragments.add(VpContentFragment.newInstance("title5", ""))
        fragments.add(VpContentFragment.newInstance("title6", ""))

        titles.add("title1")
        titles.add("title2")
        titles.add("title3")
        titles.add("title4")
        titles.add("title5")
        titles.add("title6")
    }
}