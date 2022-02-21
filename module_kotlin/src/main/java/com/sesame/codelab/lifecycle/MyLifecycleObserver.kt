package com.sesame.codelab.lifecycle

import android.util.Log
import androidx.lifecycle.*

class MyLifecycleObserver: DefaultLifecycleObserver {

    private val TAG = "MyLifecycleObserver"

//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    fun onStart(){
//        Log.w(TAG, "onStart: ")
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    fun onResume(){
//        Log.w(TAG, "onResume: ")
//    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.w(TAG, "onResume: ")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.w(TAG, "onPause: ")
    }
}