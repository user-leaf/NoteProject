package com.sesame.module_test.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class OneTimeEvent<out T>(private val content: T) {
    private var hasBeenHandled = false

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class OneTimeLiveData<T> : MutableLiveData<OneTimeEvent<T>> {
    constructor() : super()
    constructor(value: T) : super(OneTimeEvent(value))

    fun postOneTimeValue(value: T?) {
        super.postValue(value?.run { OneTimeEvent(this) })
    }

    fun setOneTimeValue(value: T?) {
        super.setValue(value?.run { OneTimeEvent(this) })
    }

    fun observeOneTime(owner: LifecycleOwner, observer: Observer<in T>) {
        observe(owner) {
            it.getContentIfNotHandled()?.let { value ->
                observer.onChanged(value)
            }
        }
    }
}