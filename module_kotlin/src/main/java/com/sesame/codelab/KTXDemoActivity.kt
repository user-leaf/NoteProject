package com.sesame.codelab

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import com.sesame.codelab.lifecycle.MyLifecycleObserver
import com.sesame.codelab.livedata.MyLiveData
import com.sesame.codelab.livedata.StockLiveData
import com.sesame.codelab.viewmodel.MyViewModel
import com.sesame.codelab.viewmodel.Person
import com.sesame.module_kotlin.R
import kotlinx.android.synthetic.main.activity_demo_ktx.*
import java.math.BigDecimal

class KTXDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_ktx)
        lifecycle.addObserver(MyLifecycleObserver())

        val sharedPreferences = this.getSharedPreferences("", Context.MODE_PRIVATE)
        sharedPreferences.edit(commit = true) { putBoolean("key", true) }

        val list = arrayListOf(1, 2, 3) + arrayListOf(4, 5, 6)
        val newList = list + 7 + 8
        println(newList)

        supportFragmentManager.commit {
            add(R.id.container, KTXDemoFragment(), "test")
        }

        val viewModel: MyViewModel by viewModels()
        viewModel.persons.observe(this) {
            println("person name: $it")
        }

//        viewModel.persons.observeForever {
//            println(it)
//        }


        val myPriceListener: LiveData<BigDecimal> = StockLiveData("sss")
        myPriceListener.observe(this) {

        }

        btnChangeValue.setOnClickListener {
            viewModel.persons.value = "haha"
        }

        MyLiveData.personList.observe(this){
            println("Activity里: $it")
        }

        var age = 18
        btnAddPerson.setOnClickListener {
            val person = Person("张三", age++)
            MyLiveData.addPerson(person)
        }

    }
}