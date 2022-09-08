package com.bamboo.nano

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.nano.message.NoticeActivity
import com.bamboo.nano.news.NewsActivity
import com.bamboo.nano.popup.PopupActivity
import com.bamboo.nano.search.SearchActivity
import com.bamboo.nano.search_copy.Search2Activity
import com.bamboo.nano.user.UserActivity
import com.bamboo.nano.viewpager_hq.HqChooseActivity
import com.bamboo.newrise.NewriseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (true){
            val intent = Intent(this, NewriseActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnNotice.setOnClickListener {
            val intent = Intent(this, NoticeActivity::class.java)
            startActivity(intent)
        }

        btnNews.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }

        btnHqShow.setOnClickListener {
            val intent = Intent(this, HqChooseActivity::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        btnSearch2.setOnClickListener {
            val intent = Intent(this, Search2Activity::class.java)
            startActivity(intent)
        }

        btnUser.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        btnPopup.setOnClickListener {
            val intent = Intent(this, PopupActivity::class.java)
            startActivity(intent)
        }
    }
}