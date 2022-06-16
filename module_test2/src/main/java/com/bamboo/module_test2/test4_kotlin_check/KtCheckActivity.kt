package com.bamboo.module_test2.test4_kotlin_check

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sesame.module_base.utils.FileUtils
import java.lang.reflect.Type

class KtCheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4_kotlin_check)

        Thread {
            val json = FileUtils.getJson(this, "data.json")
            val type: Type = object : TypeToken<BaseModel<List<PersonModel>>>() {}.type
            val model = Gson().fromJson<BaseModel<List<PersonModel>>>(json, type)
            println(model?.value?.get(0)?.name)
        }.start()

    }
}