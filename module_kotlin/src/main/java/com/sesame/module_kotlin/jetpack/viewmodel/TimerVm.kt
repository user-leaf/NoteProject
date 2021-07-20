package com.sesame.module_kotlin.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class TimerVm : ViewModel() {

    private var currentTime: Int = 0
    private lateinit var onTimerCallback: OnTimerCallback

    //    private var observable: Observable<Long>? = null
    private lateinit var observable: Observable<Long>
    fun startTimer() {
        // Kotlin判断lateinit变量初始化状态
        // https://blog.csdn.net/vitaviva/article/details/105980404
        if (!this::observable.isInitialized) {
            observable = Observable.interval(0, 1, TimeUnit.SECONDS)
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    onTimerCallback.onTimeChanged(currentTime++)
                }
        }
    }

    fun setOnTimerCallback(callback: OnTimerCallback) {
        onTimerCallback = callback
    }

    override fun onCleared() {
        super.onCleared()
    }
}
