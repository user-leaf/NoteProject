package com.sesame.module_test.test_personal_page

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val service: PersonalPageNetwork by lazy {
    val okHttpClient = OkHttpClient.Builder()
//        .addInterceptor(SkipNetworkInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/users/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(PersonalPageNetwork::class.java)
}

fun getNetworkService() = service

/**
 * Main network interface which will fetch a new welcome title for us
 */
interface PersonalPageNetwork {
    @GET("user-leaf")
    suspend fun fetchUserInfo(): UserInfo
}


