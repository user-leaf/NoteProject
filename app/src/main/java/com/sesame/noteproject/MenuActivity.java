package com.sesame.noteproject;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.merge.MergeActivity;
import com.sesame.noteproject.test_company.TitleActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tvMerge, R.id.tvTitleBar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvMerge:
                MergeActivity.startActivity(this);
                break;
            case R.id.tvTitleBar:
                TitleActivity.startActivity(this);
                break;
        }
    }
}
