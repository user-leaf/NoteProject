package com.bamboo.module_test2.test15_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bamboo.module_test2.R
import kotlinx.android.synthetic.main.fragment_test15_left.*

class FragmentTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_fragment)
        btn1.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.rightLayout, fragment)
            .addToBackStack(null)
            .commit()
    }


}