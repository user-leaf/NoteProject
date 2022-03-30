package com.bamboo.nano.viewpager_hq

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.activity_hq_choose.*

class HqChooseActivity: AppCompatActivity() {
    val fragments = mutableListOf<HqChooseFragment>()
    private val defaultPosition = 1
    private var choicePosition = defaultPosition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq_choose)

        fragments.add(HqChooseFragment(0))
        fragments.add(HqChooseFragment(1))
        fragments.add(HqChooseFragment(2))

        vpContent.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int {
                return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }
        }

        vpContent.offscreenPageLimit = fragments.size
        vpContent.pageMargin = 30
//        vpContent.setPageTransformer(true, ViewPager.PageTransformer { page, position ->
//            page.scaleY = (1f - 0.3 * abs(position)).toFloat()
//            page.scaleX = (1f - 0.3 * abs(position)).toFloat()
//        })

        vpContent.setPageTransformer(false, ScalePageTransformer(false))
        vpContent.setCurrentItem(defaultPosition, false)

        btnCommit.setOnClickListener {
            Toast.makeText(this, "$choicePosition", Toast.LENGTH_SHORT).show()
        }
    }

    fun setChecked(position: Int){
        choicePosition = position
        for (fragment in fragments){
            if (fragment.getPosition() == position){
                fragment.setChecked(true)
            }else{
                fragment.setChecked(false)
            }
        }
    }
}