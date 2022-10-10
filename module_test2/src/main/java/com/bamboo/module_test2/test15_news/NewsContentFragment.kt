package com.bamboo.module_test2.test15_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bamboo.module_test2.R
import kotlinx.android.synthetic.main.fragment_test15_news_content.*

class NewsContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test15_news_content, container, false)
    }

    fun refresh(title: String, content: String) {
        contentLayout.visibility = View.VISIBLE
        newsTitle.text = title
        newsContent.text = content
    }
}