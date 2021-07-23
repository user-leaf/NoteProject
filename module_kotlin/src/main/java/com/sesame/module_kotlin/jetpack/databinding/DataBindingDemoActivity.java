package com.sesame.module_kotlin.jetpack.databinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sesame.module_kotlin.R;
import com.sesame.module_kotlin.databinding.ActivityDemoDatabindingBinding;
import com.sesame.module_kotlin.jetpack.databinding.twowaybinding.TwoWayBindingFieldViewModel;
import com.sesame.module_kotlin.jetpack.databinding.twowaybinding.TwoWayBindingViewModel;

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

        // 自定义BindingAdapter
        dataBinding.setNetworkImage("https://img1.baidu.com/it/u=3676446160,2628100231&fm=26&fmt=auto&gp=0.jpg");

        // 方法重载
        dataBinding.setLocalImage(R.mipmap.ic_launcher);

        // 双向绑定
        dataBinding.setViewModel(new TwoWayBindingViewModel());

        // 使用ObservableField优化双向绑定
        dataBinding.setVm(new TwoWayBindingFieldViewModel());
    }
}
