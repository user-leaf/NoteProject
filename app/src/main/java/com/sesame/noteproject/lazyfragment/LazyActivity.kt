package com.sesame.noteproject.lazyfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.sesame.noteproject.R
import kotlinx.android.synthetic.main.activity_lazy_fragment.*

class LazyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lazy_fragment)

        viewPager_Fragment()

        addHideShow_Fragment()
    }

    private fun viewPager_Fragment() {
        val list = mutableListOf<LazyLoadFragment>()
        list.add(LazyLoadFragment.newInstance("aaa"))
        list.add(LazyLoadFragment.newInstance("bbb"))
        list.add(LazyLoadFragment.newInstance("ccc"))
        viewPager.offscreenPageLimit = list.size
        // 不知道这样写对不对。
        viewPager.adapter = LazyLoadViewPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            list
        )
    }

    private fun addHideShow_Fragment() {
        // https://www.jianshu.com/p/2201a107d5b5?utm_campaign=hugo
        // 借鉴ViewPager+Fragment中adapter的setMaxLifecycle
    }

}