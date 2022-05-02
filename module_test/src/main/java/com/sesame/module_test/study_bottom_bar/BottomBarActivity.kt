package com.sesame.module_test.study_bottom_bar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.sesame.module_test.R
import com.sesame.module_test.databinding.ActivityStudyBottomBarBinding

class BottomBarActivity : AppCompatActivity() {

    private val fragments = mutableListOf<Fragment>()
    private lateinit var binding: ActivityStudyBottomBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudyBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments.add(VpHomeFragment.newInstance("首页", ""))
        fragments.add(VpContentFragment.newInstance("发现", ""))
        fragments.add(VpContentFragment.newInstance("我的", ""))

        binding.viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
                return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

        }

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                onPagerSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
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

        val badge = binding.bottomNavView.getOrCreateBadge(R.id.menu_mine)
        badge.number = 100
        badge.maxCharacterCount = 3

        binding.bottomNavView.getOrCreateBadge(R.id.menu_find)
    }

    private fun onPagerSelected(position: Int) {
        when (position) {
            0 -> {
                binding.bottomNavView.selectedItemId = R.id.menu_home
            }
            1 -> {
                binding.bottomNavView.removeBadge(R.id.menu_find)
                binding.bottomNavView.selectedItemId = R.id.menu_find

            }
            2 -> {
                binding.bottomNavView.removeBadge(R.id.menu_mine)
                binding.bottomNavView.selectedItemId = R.id.menu_mine
            }
            else -> {}
        }
    }
}