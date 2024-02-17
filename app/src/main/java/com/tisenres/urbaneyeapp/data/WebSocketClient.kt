package com.tisenres.urbaneyeapp.data

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketClient {
    private var webSocket: WebSocket? = null
    
    fun connectWebSocket() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("wss://echo.websocket.org")
            .build()
        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.d("TETTETE", "OPEN")
            }
            
            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.d("TETTETE", "MESSAGE")
            }
            
            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                // WebSocket connection closed
            }
            
            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                // WebSocket connection failure
            }
        })
    }
    
    fun sendMessage(message: String?) {
        if (webSocket != null) {
            webSocket!!.send(message!!)
        }
    }
    
    fun disconnectWebSocket() {
        if (webSocket != null) {
            webSocket!!.close(1000, "Goodbye, World!")
        }
    }
}