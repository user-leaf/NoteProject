package com.sesame.module_test.test_search_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.sesame.module_test.R

class SearchActivity : AppCompatActivity() {

    private val containerId = R.id.flContainer
    private val fm = supportFragmentManager

    private val showFragmentManager by lazy {
        ShowFragmentManager(supportFragmentManager, R.id.flContainer) {
            if (it == 0) {
                SearchListFragment.newInstance()
            } else {
                SearchHistoryFragment.newInstance()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_search)
//        fm.commit {
//            val fragments = mutableListOf<Fragment>()
//            fragments.add(SearchListFragment.newInstance())
//            fragments.add(SearchHistoryFragment.newInstance())
//            add(containerId, fragments[0], makeFragmentName(0))
//            add(containerId, fragments[1], makeFragmentName(1))
//            fragments.forEach {
//                hide(it)
//            }
//        }
//        showFragment(0)

        showFragmentManager.showFragment(0)
    }

    private fun showFragment(index: Int) {
        fm.commit {
            val fragment = fm.findFragmentByTag(makeFragmentName(index))
            if (fragment != null) {
                show(fragment)
            } else {
                if (index == 0)
                    add(containerId, SearchListFragment.newInstance(), makeFragmentName(0))
                else
                    add(containerId, SearchHistoryFragment.newInstance(), makeFragmentName(1))
            }
        }
    }

    private fun makeFragmentName(index: Int): String {
        return "fragment_$index"
    }
}