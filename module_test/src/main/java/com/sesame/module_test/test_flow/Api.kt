package com.sesame.module_test.test_flow

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{userName}")
    suspend fun getUser(@Path("userName") userName: String): User
}