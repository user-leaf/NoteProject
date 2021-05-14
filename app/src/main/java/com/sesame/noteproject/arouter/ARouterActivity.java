package com.sesame.noteproject.arouter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.sesame.noteproject.R;

@Route(path = VRouterPath.Activity_ARouter)
public class ARouterActivity extends AppCompatActivity {

    @Autowired(name = "key1")
    public String name;

    @Autowired
    public long id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);

        ARouter.getInstance().inject(this);

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText("name: " + name + ", id: "+id);

    }
}
