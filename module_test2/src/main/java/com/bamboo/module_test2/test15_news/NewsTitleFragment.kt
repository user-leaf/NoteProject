package com.bamboo.module_test2.test15_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.bamboo.module_test2.R
import com.bamboo.module_test2.test15_news.model.NewsInfo
import kotlinx.android.synthetic.main.activity_test15_news.*
import kotlinx.android.synthetic.main.fragment_test15_news_title.*

class NewsTitleFragment : Fragment() {

    private var isTwoPanel = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test15_news_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("@@@activity is null: ${activity == null}")
        // 此时还没有newsContentLayout，这句代码结果始终为false
//        isTwoPanel = activity?.findViewById<View>(R.id.newsContentLayout) != null

        recyclerView.layoutManager = LinearLayoutManager(context, OrientationHelper.VERTICAL, false)
        recyclerView.adapter = NewsAdapter(getNews())
    }

    private fun getNews(): List<NewsInfo> {
        val list = ArrayList<NewsInfo>()
        for (i in 1..50) {
            list.add(NewsInfo("这是标题$i", getRandomLengthString("这是内容$i。")))
        }
        return list
    }

    private fun getRandomLengthString(s: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(s)
        }
        return builder.toString()
    }

    inner class NewsAdapter(val newsList: List<NewsInfo>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.tvTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_news_title, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {

                isTwoPanel = activity?.findViewById<View>(R.id.newsContentLayout) != null

                val newsInfo = newsList[holder.layoutPosition]
                if (isTwoPanel) {
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(newsInfo.title, newsInfo.content)
                } else {
                    NewsContentActivity.startActivity(
                        parent.context,
                        newsInfo.title,
                        newsInfo.content
                    )
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.newsTitle.text = newsList[position].title
        }

        override fun getItemCount(): Int {
            return newsList.size
        }

    }
}