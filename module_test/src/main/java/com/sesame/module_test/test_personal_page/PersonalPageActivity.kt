package com.sesame.module_test.test_personal_page

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_test_personal_page.*

class PersonalPageActivity : AppCompatActivity() {

    private val viewModel by viewModels<PersonalPageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_personal_page)

        viewModel.userInfo.observe(this) {
            Glide.with(this).load(it.avatar_url).into(ivHeader)
            tvName.text = it.name
        }

        viewModel.getInfo()
    }
}