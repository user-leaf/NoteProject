package com.sesame.module_chart_view

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tradingview.lightweightcharts.api.interfaces.ChartApi
import com.tradingview.lightweightcharts.api.interfaces.SeriesApi
import com.tradingview.lightweightcharts.api.options.models.crosshairOptions
import com.tradingview.lightweightcharts.api.options.models.layoutOptions
import com.tradingview.lightweightcharts.api.options.models.priceScaleOptions
import com.tradingview.lightweightcharts.api.options.models.timeScaleOptions
import com.tradingview.lightweightcharts.api.series.common.SeriesData
import com.tradingview.lightweightcharts.api.series.enums.CrosshairMode
import com.tradingview.lightweightcharts.api.series.models.HistogramData
import com.tradingview.lightweightcharts.api.series.models.PriceScaleId
import com.tradingview.lightweightcharts.api.series.models.Time
import com.tradingview.lightweightcharts.api.series.models.WhitespaceData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var histogramSeries: SeriesApi
//    private var series: MutableList<SeriesApi> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applyChartOptions()

        val viewModel = ViewModelProvider(this).get(TestChartViewModel::class.java)

        viewModel.seriesData2.observe(this, { data ->
//            createSeriesWithData(data, PriceScaleId.RIGHT, charts_view.api){ series ->
//                this.series.forEach(charts_view.api::removeSeries)
//                this.series.clear()
//                this.series.add(series)
//            }

            charts_view.api.addHistogramSeries(
                onSeriesCreated = { api ->
                    api.setData(data)
                }
            )
        })

        viewModel.loadData2()

        btnGetData.setOnClickListener {
            val data = listOf(
                HistogramData(Time.BusinessDay(2019, 6, 11), 40.01f),
                HistogramData(Time.BusinessDay(2019, 6, 12), 52.38f),
                HistogramData(Time.BusinessDay(2019, 6, 13), 36.30f),
                HistogramData(Time.BusinessDay(2019, 6, 14), 34.48f),
                WhitespaceData(Time.BusinessDay(2019, 6, 15)),
                WhitespaceData(Time.BusinessDay(2019, 6, 16)),
                HistogramData(Time.BusinessDay(2019, 6, 17), 41.50f),
                HistogramData(Time.BusinessDay(2019, 6, 18), 34.82f)
            )

            charts_view.api.addHistogramSeries(

                onSeriesCreated = { api ->
                    api.setData(data)
//                histogramSeries = api
                }
            )
        }
    }

    private fun createSeriesWithData(
        data: List<SeriesData>,
        priceScale: PriceScaleId,
        chartApi: ChartApi,
        onSeriesCreated: (SeriesApi) -> Unit
    ) {
        chartApi.addHistogramSeries(
//            options = BarSeriesOptions(
//                priceScaleId = priceScale,
//                thinBars = true,
//                downColor = Color.BLACK,
//                upColor = Color.BLACK,
//            ),
            onSeriesCreated = { api ->
                api.setData(data)
                onSeriesCreated(api)
            }
        )
    }

    private fun applyChartOptions() {
        charts_view.api.applyOptions {
            layout = layoutOptions {
                backgroundColor = Color.WHITE
                textColor = Color.argb(255, 33, 56, 77)
            }
            crosshair = crosshairOptions {
                mode = CrosshairMode.NORMAL
            }
            rightPriceScale = priceScaleOptions {
                borderColor = Color.argb(255, 197, 203, 206)
            }
            timeScale = timeScaleOptions {
                borderColor = Color.argb(255, 197, 203, 206)
            }
        }

//        charts_view.api.applyOptions {
//            layout = layoutOptions {
//                backgroundColor = Color.LTGRAY
//                textColor = Color.BLACK
//            }
//            localization = localizationOptions {
//                locale = "ru-RU"
//                priceFormatter = PriceFormatter(template = "{price:#2:#3}$")
//                timeFormatter = TimeFormatter(
//                    locale = "ru-RU",
//                    dateTimeFormat = DateTimeFormat.DATE_TIME
//                )
//            }
//        }
    }

}