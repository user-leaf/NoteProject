package com.bamboo.nano.api

data class BasePageInfo<T>(
    var total: Int = 0,
    var pageSize: Int = 0,
    var currentPage: Int = 0,
    var resultList: List<T> = arrayListOf(),
    var unReadSize: Int = 0
)
