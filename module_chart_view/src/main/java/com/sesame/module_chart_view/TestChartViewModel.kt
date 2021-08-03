package com.sesame.module_chart_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sesame.module_chart_view.repository.StaticRepository
import com.tradingview.lightweightcharts.api.series.common.SeriesData
import com.tradingview.lightweightcharts.api.series.enums.SeriesType
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.api.series.models.WhitespaceData
import kotlinx.coroutines.launch

class TestChartViewModel : ViewModel() {

    private val staticRepository = StaticRepository()

    var seriesData2: MutableLiveData<List<SeriesData>> = MutableLiveData()

    val seriesData: LiveData<List<SeriesData>>
        get() = data

    private val data: MutableLiveData<List<SeriesData>> by lazy {
        MutableLiveData<List<SeriesData>>().also {
            loadData()
        }
    }

    fun loadData() {
//        viewModelScope.launch {
//            val barData = staticRepository.getBarChartSeriesData()
//            data.postValue(Data(barData, SeriesType.HISTOGRAM))
//        }

        viewModelScope.launch {
            val myData = listOf(
                HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
                HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
                HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
                HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
                WhitespaceData(Time.BusinessDay(2019, 6, 15)),
                WhitespaceData(Time.BusinessDay(2019, 6, 16)),
                HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
                HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
            )
            data.postValue(myData)
        }
    }

    fun loadData2() {
        val myData = listOf(
            HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
            HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
            HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
            HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
            WhitespaceData(Time.BusinessDay(2019, 6, 15)),
            WhitespaceData(Time.BusinessDay(2019, 6, 16)),
            HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
            HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
        )

        seriesData2.postValue(myData)
    }

}