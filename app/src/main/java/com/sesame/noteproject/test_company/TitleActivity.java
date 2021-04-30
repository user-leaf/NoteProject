package com.sesame.noteproject.test_company;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.MenuActivity;
import com.sesame.noteproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TitleActivity extends AppCompatActivity {

    @BindView(R.id.mainTitle)
    MainTitle mMainTitle;

    public static void startActivity(Context context){
        context.startActivity(new Intent(context, TitleActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        ButterKnife.bind(this);
        setSupportActionBar(mMainTitle.getToolBar());
    }
}
