package com.sesame.module_kotlin.jetpack.lifecycle.page

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationListener: LifecycleObserver{
    private val TAG = MyLocationListener::class.java.simpleName
    private lateinit var onLocationChangedCallback: OnLocationChangedCallback

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startGetLocation(){
        Log.d(TAG, "startGetLocation()")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun stopGetLocation(){
        Log.d(TAG, "stopGetLocation()")
    }

    fun setOnLocationChangedCallback(callback: OnLocationChangedCallback){
        this.onLocationChangedCallback = callback
    }

}