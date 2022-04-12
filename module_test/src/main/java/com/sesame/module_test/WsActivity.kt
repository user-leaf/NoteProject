package com.sesame.module_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_test_ws.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.ByteString
import java.util.concurrent.TimeUnit

/*
https://baijiahao.baidu.com/s?id=1661934194124740212&wfr=spider&for=pc
https://juejin.cn/post/6847009772198166536
 */
class WsActivity: AppCompatActivity() {

    var mockWebServer: MockWebServer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_ws)

        btnMock.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    mockWebServer()
                }

            }
        }

        btnConn.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    connect(mockWebServer?.hostName?:"", mockWebServer?.port?:80)
                }
            }
        }
    }

    private fun connect(hostName:String, port:Int){
        val httpClient = OkHttpClient.Builder()
            .pingInterval(40, TimeUnit.SECONDS)
            .build()
        val webSocketUrl = "ws://$hostName:$port/"
//        val webSocketUrl = "ws://echo.websocket.org"
        val request = Request.Builder()
            .url(webSocketUrl)
            .build()
        httpClient.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                Log.d("@@@Conn", "onOpen: ")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                Log.d("@@@Conn", "onMessage text: ")

            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                Log.d("@@@Conn", "onMessage bytes: ")

            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                Log.d("@@@Conn", "onClosing: ")

            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                Log.d("@@@Conn", "onClosed: ")

            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Log.d("@@@Conn", "onFailure: ${t.message}")

            }
        })
    }

    private fun mockWebServer(){
        if (mockWebServer != null){
            return
        }
        mockWebServer = MockWebServer()
        val response = MockResponse().withWebSocketUpgrade(object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                Log.d("@@@Mock", "onOpen: ")

            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                Log.d("@@@Mock", "onMessage: ")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                Log.d("@@@Mock", "onClosing: ")
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                Log.d("@@@Mock", "onClosed: ")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Log.d("@@@Mock", "onFailure: ")
            }
        })
        mockWebServer?.enqueue(response)
    }

}