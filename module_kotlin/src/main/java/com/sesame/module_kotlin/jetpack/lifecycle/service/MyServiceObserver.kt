package com.sesame.module_kotlin.jetpack.lifecycle.service

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyServiceObserver : LifecycleObserver {

    private val TAG: String? = MyServiceObserver::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun startGetLocation() {
        Log.d(TAG, "startGetLocation: observer")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun stopGetLocation() {
        Log.d(TAG, "stopGetLocation: observer")
    }
}