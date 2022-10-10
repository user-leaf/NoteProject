package com.bamboo.module_test2.test15_news

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R
import kotlinx.android.synthetic.main.activity_test15_news_content.*

class NewsContentActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test15_news_content)
        val title = intent.getStringExtra("news_title") ?: ""
        val content = intent.getStringExtra("news_content") ?: ""

        val fragment = contentFrag as NewsContentFragment
        fragment.refresh(title, content)
    }
}