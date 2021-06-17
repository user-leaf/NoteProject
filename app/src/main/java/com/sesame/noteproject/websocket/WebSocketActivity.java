package com.sesame.noteproject.websocket;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * https://blog.csdn.net/xlh1191860939/article/details/75452342/
     */
    private TextView text;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, WebSocketActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websocket);
        findViewById(R.id.start).setOnClickListener(this);
        text = findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        connect();
    }

    private void connect() {
        EchoWebSocketListener listener = new EchoWebSocketListener();
        Request request = new Request.Builder()
                .url("ws://echo.websocket.org")
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
    }

    private final class EchoWebSocketListener extends WebSocketListener {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
            webSocket.send("hello world");
            webSocket.send("welcome");
            webSocket.send(ByteString.decodeHex("adef"));
            webSocket.close(1000, "再见");
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            output("onMessage: " + text);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
            output("onMessage byteString: " + bytes);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
            webSocket.close(1000, null);
            output("onClosing: " + code + "/" + reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
            output("onClosed: " + code + "/" + reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
            output("onFailure: " + t.getMessage());
        }
    }

    private void output(final String content) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(text.getText().toString() + content + "\n");
            }
        });
    }
}
