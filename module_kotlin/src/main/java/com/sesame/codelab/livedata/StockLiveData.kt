package com.sesame.codelab.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.sesame.codelab.StockManager
import java.math.BigDecimal

class StockLiveData(symbol: String) : LiveData<BigDecimal>() {

    val stockManager = StockManager(symbol)

    val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {
        super.onActive()
        stockManager.addListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        stockManager.removeListener(listener)
    }

    companion object {
        private lateinit var sInstance: StockLiveData

        @MainThread
        fun get(symbol: String): StockLiveData {
            sInstance = if (::sInstance.isInitialized) sInstance else StockLiveData(symbol)
            return sInstance
        }
    }
}