package com.sesame.module_test.test_flow

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sesame.module_test.databinding.ActivityTestFlowBinding
import kotlinx.android.synthetic.main.activity_test_flow.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {

    private val viewModel by viewModels<FlowViewModel>()

    private val aaa by lazy {
        println("aaa init")
        "hello kotlin"
    }
    private val aaa2 = ""
    private lateinit var bbb: String

    private lateinit var binding: ActivityTestFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

        }

        this.lifecycleScope.launch {
            viewModel.valueFlow.collect {
                tvShow.text = it
            }
        }

        btnChangeValue.setOnClickListener {
            viewModel.loadData()

        }

        btnSimpleFlow.setOnClickListener {
            lifecycleScope.launch {
                viewModel.simpleFlow.collect {
                    tvSimpleFlow.text = "simple flow: $it"
                }
            }

            viewModel.getUser()
        }

        btnTest.setOnClickListener {
            bbb = "hello" // 如果没有赋值就使用，直接抛出异常。
            println(bbb.length)

            println(aaa)
            println(aaa)
        }
    }
}