package com.sesame.module_test.test_flow

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.github.com/"
    var retrofit: Retrofit

    init {
        retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    inline fun <reified T> getApi(): T {
        return retrofit.create(T::class.java)
    }
}