package com.bamboo.nano.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class ShowFragmentManager(
    val fm: FragmentManager,
    val containerId: Int,
    val fragmentFactory: (Int) -> Fragment
) {

    private val fragments = mutableListOf<Fragment>()

    fun showFragment(index: Int) {
        fm.commit {
            val name = makeFragmentName(index)
            var fragment = fm.findFragmentByTag(name)
            if (fragment == null) {
                fragment = fragmentFactory(index)
                fragments.add(fragment)
                add(containerId, fragment, name)
            }
            for (frg in fragments) {
                hide(frg)
            }
            show(fragment)
        }
    }

    private fun makeFragmentName(index: Int): String {
        return "showFragment:$containerId:$index"
    }
}