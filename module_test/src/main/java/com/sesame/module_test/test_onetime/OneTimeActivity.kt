package com.sesame.module_test.test_onetime

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_test_onetime.*

class OneTimeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_onetime)

        val viewModel by viewModels<OneTimeViewModel>()

        viewModel.message1.observeOneTime(this){
            Toast.makeText(this, "content:$it", Toast.LENGTH_SHORT).show()
        }

        btnShow.setOnClickListener{
            viewModel.showMessage()
        }
    }
}