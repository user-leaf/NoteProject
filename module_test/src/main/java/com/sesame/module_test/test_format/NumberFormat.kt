package com.sesame.module_test.test_format

import java.text.DecimalFormat

fun main() {
    val pi = 3.1415927 //圆周率
    //取一位整数
    println(DecimalFormat("0").format(pi)) //3
    //取一位整数和两位小数
    println(DecimalFormat("0.00").format(pi)) //3.14
    //取两位整数和三位小数，整数不足部分以0填补。
    println(DecimalFormat("00.000").format(pi)) // 03.142
    //取所有整数部分
    println(DecimalFormat("#").format(pi)) //3
    //以百分比方式计数，并取两位小数
    println(DecimalFormat("#.##%").format(pi)) //314.16%

    val c: Long = 299792458 //光速
    //显示为科学计数法，并取五位小数
    println(DecimalFormat("#.#####E0").format(c)) //2.99792E8
    //显示为两位整数的科学计数法，并取四位小数
    println(DecimalFormat("00.####E0").format(c)) //29.9792E7
    //每三位以逗号进行分隔。
    println(DecimalFormat(",###").format(c)) //299,792,458
    //将格式嵌入文本
    println(DecimalFormat("光速大小为每秒,###米。").format(c))

    val value = 12345.67890
    println(DecimalFormat("#,##0.00").format(value)) //12,345.67


    val d = 0.12029
    println(DecimalFormat("#,###.00").format(d)) //.12
    println(DecimalFormat("#,###.00").format(0.010)) //.01
    println(DecimalFormat("#.###").format(0.010))//0.01

    //我：0是强制保留
}