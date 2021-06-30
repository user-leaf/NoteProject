package com.sesame.module_kotlin.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils {

    companion object{
        fun getRetrofit(baseUrl: String): Retrofit {
            return Retrofit.Builder()
//            .baseUrl(baseUrl)
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

}