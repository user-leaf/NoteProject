package com.bamboo.nano.news

import com.bamboo.nano.news.model.BaseNewsInfo2
import com.bamboo.nano.news.model.NewsInfo2
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiNews {

    @GET("/myinfo/news")
    @Headers("url:USER")
    suspend fun getEconomicNews(
        @Query("lang") lang: String?,
        @Query("size") size: Int,
        @Query("page") page: Int
    ): BaseNewsInfo2<List<NewsInfo2>>

}