package com.bamboo.module_test2.test5_metadata

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R
import com.bamboo.module_test2.Test2Application
import com.orhanobut.hawk.Hawk

class MetaDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test5_metadata)

//        val result = getMetaData()
//        println("@@@ $result")
    }

//    private fun getMetaData(): String {
//        val channel = Hawk.get<String>("channel")
//        if (!TextUtils.isEmpty(channel)){
//            return channel
//        }
//
//        this.application.packageManager.get
//    }
}