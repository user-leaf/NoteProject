package com.sesame.module_kotlin.jetpack.databinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sesame.module_kotlin.R;
import com.sesame.module_kotlin.databinding.ActivityDemoDatabindingBinding;

public class DataBindingDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_demo_databinding);
        ActivityDemoDatabindingBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_demo_databinding);

        BookInfo book = new BookInfo("Android", "无名", "五星");
//        dataBinding.setVariable(BR.book, book);
        dataBinding.setBook(book);
        dataBinding.setEventHandler(new EventHandleListener(this));
    }
}
