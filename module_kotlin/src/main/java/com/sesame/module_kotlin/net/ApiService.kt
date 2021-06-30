package com.sesame.module_kotlin.net

import com.sesame.module_kotlin.model.BasePageInfo
import com.sesame.module_kotlin.model.BaseRequest
import com.sesame.module_kotlin.model.PostCodeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("postcode/query")
    fun getPostCode(
        @Query("postcode") postcode: String,
        @Query("key") key: String
    ): Call<BaseRequest<BasePageInfo<PostCodeModel>>>
}
