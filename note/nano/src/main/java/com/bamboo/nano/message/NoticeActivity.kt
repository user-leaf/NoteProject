package com.bamboo.nano.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.activity_notice.*

class NoticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)

        rgMenu.setOnCheckedChangeListener { _, id ->
            if (id == R.id.rbNotice) {
                vpContent.setCurrentItem(0, false)
            } else if (id == R.id.rbMessage) {
                vpContent.setCurrentItem(1, false)
            }
        }

        val fragments =
            mutableListOf(NoticeFragment.newInstance("通知"), NoticeFragment.newInstance("消息"))

//        vpContent.adapter = object :
//            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//            override fun getCount(): Int {
//                return fragments.size
//            }
//
//            override fun getItem(position: Int): Fragment {
//                return fragments[position]
//            }
//        }

        vpContent.adapter = viewPagerAdapter(supportFragmentManager, fragments)

        vpContent.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position==0){
                    rbNotice.isChecked = true
                }else if (position == 1){
                    rbMessage.isChecked = true
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })
    }
}