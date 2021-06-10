package com.sesame.noteproject.deeplink.simple_use;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sesame.noteproject.R;
import com.sesame.noteproject.arouter.VRouterPath;

@Route(path = VRouterPath.Activity_Deeplink_Goal)
public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        ARouter.getInstance().inject(this);
        TextView tv = findViewById(R.id.tv);
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri == null) {
                return;
            }
//            uri = Uri.parse("cc://hostname.com/abc");
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if ("cc".equals(scheme)) {
                tv.setText(uri.toString() + "\nscheme:" + scheme + "\nhost:" + host + "\n值：" + uri.getPathSegments());
            }
        }
    }
}
