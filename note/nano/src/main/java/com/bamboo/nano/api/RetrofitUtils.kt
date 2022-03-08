package com.bamboo.nano.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://app.swmarkets.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}