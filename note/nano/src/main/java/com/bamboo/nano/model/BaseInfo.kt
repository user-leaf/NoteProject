package com.bamboo.nano.model

import com.google.gson.annotations.SerializedName
import java.lang.Exception

data class BaseInfo<T>(var value: T? = null,
                       var isCache: Boolean = false,
                       var errCode: Int = 0,
                       @SerializedName("success")
                       var isSuccessful: Boolean = false,
                       var message: String = "",
                       var throwable: Throwable?=null) {
    fun isLoginTimeOut(): Boolean = errCode == 2

    fun checkSuccess(){
        if (!isSuccessful) {
            throw ResponseError(errCode, message)
        }
    }

    fun getValueWithCheck(): T {
        checkSuccess()
        return value ?: throw ResponseError(0, "value is null")
    }
}

class ResponseError(var code:Int,var msg:String):Exception(msg)
