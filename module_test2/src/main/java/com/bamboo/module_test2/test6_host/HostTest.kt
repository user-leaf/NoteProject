package com.bamboo.module_test2.test6_host

import java.net.URI

fun main() {
    val content = URI("https://demo-app.baidu.com/doc")

    println(content.host)
}