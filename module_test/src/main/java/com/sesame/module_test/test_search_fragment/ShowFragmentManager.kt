package com.sesame.module_test.test_search_fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class ShowFragmentManager(
    val fm: FragmentManager,
    val containerId: Int,
    val fragmentFactory: (Int) -> Fragment
) {

    fun showFragment(index: Int) {
        fm.commit {
            val name = makeFragmentName(index)
            var fragment = fm.findFragmentByTag(name)
            if (fragment != null) {
                show(fragment)
            } else {
                fragment = fragmentFactory(index)
                add(containerId, fragment, name)
            }
        }
    }

    private fun makeFragmentName(index: Int): String {
        return "showFragment:$containerId:$index"
    }
}