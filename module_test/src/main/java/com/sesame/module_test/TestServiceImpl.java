package com.sesame.module_test;

import android.content.Context;
import android.content.Intent;

import com.sesame.module_base.ITestService;

public class TestServiceImpl implements ITestService {
    @Override
    public void launch(Context context) {
        context.startActivity(new Intent(context, ModuleTestActivity.class));
    }
}
