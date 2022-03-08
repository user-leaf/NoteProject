package com.bamboo.nano.api

import com.bamboo.nano.constants.VApiMainPath
import com.bamboo.nano.constants.NotificationState
import com.bamboo.nano.model.BaseInfo
import com.bamboo.nano.model.BasePageInfo
import com.bamboo.nano.model.NoticeInfo
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiMessage {
    /**
     * 获取通知列表
     */
    @Headers("url:" + VApiMainPath.API_ORDER_HOST)
    @GET("/api/v1/notifications/page")
    suspend fun getNotification(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("startDatetime") startDatetime: String?=null,
        @Query("endDatetime") endDatetime: String?=null,
        @Query("type") type: NotificationState?=null
    ): BaseInfo<BasePageInfo<NoticeInfo>>

}