package com.sesame.codelab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.sesame.codelab.livedata.MyLiveData
import com.sesame.codelab.livedata.StockLiveData
import com.sesame.codelab.viewmodel.MyViewModel
import com.sesame.codelab.viewmodel.Person
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_demo_ktx.*

class KTXDemoFragment : Fragment() {

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

        val liveData = StockLiveData("sss2")
        liveData.observe(viewLifecycleOwner) {

        }

        StockLiveData.get("sss3").observe(viewLifecycleOwner) {

        }

        MyLiveData.personList.observe(viewLifecycleOwner) {
            println("Fragment里: $it")
        }

        var age = 1
        btnAddPerson.setOnClickListener {
            MyLiveData.addPerson(Person("李四", age++))
        }
    }
}