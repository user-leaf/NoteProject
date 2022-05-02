package com.sesame.module_test.study_bottom_bar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.sesame.module_test.R
import com.sesame.module_test.databinding.ActivityStudyBottomBarBinding

class BottomBarActivity : AppCompatActivity() {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudyBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments.add(VpContentFragment.newInstance("首页", ""))
        fragments.add(VpContentFragment.newInstance("发现", ""))
        fragments.add(VpContentFragment.newInstance("我的", ""))

        binding.viewPager.adapter =
            object : FragmentStateAdapter(supportFragmentManager, lifecycle) {
                override fun getItemCount(): Int {
                    return fragments.size
                }

                override fun createFragment(position: Int): Fragment {
                    return fragments[position]
                }

            }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.bottomNavView.selectedItemId = R.id.menu_home
                    }
                    1 -> {
                        binding.bottomNavView.selectedItemId = R.id.menu_find

                    }
                    2 -> {
                        binding.bottomNavView.selectedItemId = R.id.menu_mine
                    }
                    else -> {}
                }
            }
        })

        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    binding.viewPager.currentItem = 0
                }
                R.id.menu_find -> {
                    binding.viewPager.currentItem = 1
                }
                R.id.menu_mine -> {
                    binding.viewPager.currentItem = 2
                }
                else -> {}
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}