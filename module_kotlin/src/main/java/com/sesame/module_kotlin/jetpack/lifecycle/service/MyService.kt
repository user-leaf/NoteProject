package com.sesame.module_kotlin.jetpack.lifecycle.service

import androidx.lifecycle.LifecycleService

class MyService : LifecycleService() {

    override fun onCreate() {
        super.onCreate()

        lifecycle.addObserver(MyServiceObserver())
    }
}