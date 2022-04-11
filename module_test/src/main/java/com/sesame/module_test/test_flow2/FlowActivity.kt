package com.sesame.module_test.test_flow2

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sesame.module_test.ModuleTestActivity
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.activity_flow2.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class FlowActivity: AppCompatActivity() {

    val viewModel by viewModels<FlowViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow2)

        btnJump.setOnClickListener {
            startActivity(Intent(this, ModuleTestActivity::class.java))
            overridePendingTransition(0,0)
            this.finish()
        }

        lifecycleScope.launch {
            viewModel.uiState.collect {
                when(it){
                    is LatestNewsUiState.Success -> println(it.news)
                    is LatestNewsUiState.Error -> println(it.exception)
                }
            }
        }

        measureTimeMillis {

        }
    }
}