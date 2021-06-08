package com.sesame.noteproject.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.DeeplinkManager;
import com.sesame.noteproject.R;
import com.sesame.noteproject.arouter.VRouterPath;

public class DeeplinkActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = DeeplinkActivity.class.getSimpleName();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, DeeplinkActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/" + "deeplink.html");

        findViewById(R.id.btnDeeplink).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDeeplink:
                if (DeeplinkManager.getInstance().handlingUrls(this, Uri.parse(VRouterPath.Activity_Deeplink_Goal))){
                    Log.d(TAG, "onClick: deeplink");
                }
                break;
        }
    }
}
