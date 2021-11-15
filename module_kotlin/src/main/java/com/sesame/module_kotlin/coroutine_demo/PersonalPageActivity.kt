package com.sesame.module_kotlin.coroutine_demo

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sesame.module_kotlin.R
import com.sesame.module_kotlin.databinding.ActivityPersonalPageBinding

class PersonalPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_personal_page)

        val binding =
            DataBindingUtil.setContentView<ActivityPersonalPageBinding>(
                this,
                R.layout.activity_personal_page
            )

        val ivHead = findViewById<ImageView>(R.id.ivHead)

        val viewModel = ViewModelProvider(this).get(PPViewModel::class.java)

        viewModel.personInfoLiveData.observe(this, Observer {
            binding.info = it
            Glide.with(this).load(it.headUrl).into(ivHead)
        })

        viewModel.makeInfoRequest()
    }
}