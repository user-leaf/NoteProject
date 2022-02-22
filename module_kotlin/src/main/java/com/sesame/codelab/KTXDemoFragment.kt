package com.sesame.codelab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sesame.codelab.livedata.SharedLiveData
import com.sesame.codelab.livedata.StockLiveData
import com.sesame.codelab.viewmodel.MyViewModel
import com.sesame.codelab.viewmodel.Person
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_demo_ktx.btnAddPerson
import kotlinx.android.synthetic.main.fragment_demo_ktx.*
import java.math.BigDecimal

class KTXDemoFragment : Fragment() {

    companion object {
        fun getInstance(title: String): KTXDemoFragment {
            val fragment = KTXDemoFragment()
            val bundle = Bundle()
            bundle.putString("title", title)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val viewModel by viewModels<MyViewModel>()
    private val activityViewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_demo_ktx, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("title") ?: "title"
        tvTitle.text = title

        // https://blog.csdn.net/xiaocheng0404/article/details/103490262?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1.pc_relevant_default&utm_relevant_index=1
        // var10000.getRouterOnlineLiveData().observe((LifecycleOwner)this, (Observer)null.INSTANCE);
        // 这行代码不是很清楚吗，lambda表达式如果未持有外部类对象，那么kotlin编译器会优化，重复观察时使用同一个observer对象。
        // 然后livedata不允许重复添加，这就gg呢。

        /*
         * lambda表达式如果未持有外部类对象，那么kotlin编译器会进行单例优化，导致重复观察时使用了同一个observer对象所以造成崩溃
         */
        StockLiveData.get("sss3").observe(viewLifecycleOwner, object : Observer<BigDecimal> {
            override fun onChanged(t: BigDecimal?) {

            }
        })

        SharedLiveData.personList.observe(viewLifecycleOwner, object : Observer<List<Person>> {
            override fun onChanged(it: List<Person>?) {
                println("Fragment里: $it")
            }
        })
        var age = 1
        btnAddPerson.setOnClickListener {
            SharedLiveData.addPerson(Person("李四", age++))
        }
    }
}