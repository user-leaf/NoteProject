package com.sesame.noteproject.callphone;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.sesame.noteproject.R;
import com.sesame.noteproject.databinding.ActivityCallPhoneBinding;

// https://www.bilibili.com/video/BV1Rb4y1R7ys?p=23&spm_id_from=pageDriver
public class CallPhoneActivity extends AppCompatActivity {
    private ActivityCallPhoneBinding mBinding;
    private CallPhoneVm mCallPhoneVm;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定工作
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_call_phone);  //使类中的变量和layout中的变量绑定

        // 旧版本
//        mCallPhoneVm = ViewModelProviders.of(this).get(CallPhoneVm.class);

        // 最新版本 extends AndroidViewModel
        mCallPhoneVm = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(CallPhoneVm.class);

        // 最新版本 extends ViewModel 不需要环境
//        mCallPhoneVm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CallPhoneVm.class);

        // 绑定工作
        mBinding.setVm(mCallPhoneVm);

        // 建立感应
        mBinding.setLifecycleOwner(this); //如果不写这句，数据不会被观察到
    }
}
