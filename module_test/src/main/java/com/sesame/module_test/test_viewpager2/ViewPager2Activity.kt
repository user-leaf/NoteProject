package com.sesame.module_test.test_viewpager2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_test_view_pager2.*
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator

class ViewPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view_pager2)

        val titles = mutableListOf<String>("title1", "title2", "title3")

        miTab.navigator = CommonNavigator(this).apply {
            adapter = QuotationNavigatorAdapter(titles) {
                vpContent.setCurrentItem(it, false)
            }
        }

        val fragments = mutableListOf<ViewPager2Fragment>()
        fragments.add(ViewPager2Fragment.getInstance(titles[0]))
        fragments.add(ViewPager2Fragment.getInstance(titles[1]))
        fragments.add(ViewPager2Fragment.getInstance(titles[2]))
        vpContent.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }
        vpContent.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(applicationContext, "page: $position", Toast.LENGTH_SHORT).show()
            }
        })
        vpContent.bindIndicator(miTab)
    }
}