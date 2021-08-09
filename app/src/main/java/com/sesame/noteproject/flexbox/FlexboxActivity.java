package com.sesame.noteproject.flexbox;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.sesame.noteproject.R;

import java.util.Arrays;
import java.util.List;

public class FlexboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox);

        RecyclerView rv = findViewById(R.id.recyclerView);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        rv.setLayoutManager(layoutManager);
        List<String> names = Arrays.asList("推送和即时通讯", "蓝牙", "程序员", "影视天堂", "郭德纲", "旅行——在路上", "复仇者联盟4");
        rv.setAdapter(new RvAdapter(names));
    }
}
