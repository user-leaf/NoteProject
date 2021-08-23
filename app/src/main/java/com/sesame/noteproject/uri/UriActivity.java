package com.sesame.noteproject.uri;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;

public class UriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);

        Uri uri = Uri.parse("http://www.baidu.com:8888/aaaa/bbbb");
        System.out.println("getAuthority: "+uri.getAuthority());
        System.out.println("getScheme: " + uri.getScheme());
        System.out.println("getHost: " + uri.getHost());
        System.out.println("getPort: "+uri.getPort());
        System.out.println("getLastPathSegment: "+uri.getLastPathSegment());

    }
}
