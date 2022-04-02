package com.sesame.module_test.test_flow2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sesame.module_test.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class FlowActivity: AppCompatActivity() {

    val viewModel by viewModels<FlowViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow2)

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