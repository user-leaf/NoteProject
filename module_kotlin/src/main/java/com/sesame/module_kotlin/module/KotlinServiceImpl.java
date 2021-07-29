package com.sesame.module_kotlin.module;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sesame.module_base.IKotlinService;

public class KotlinServiceImpl implements IKotlinService {
    @Override
    public void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public Fragment getFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        ModuleKotlinFragment fragment = ModuleKotlinFragment.newInstance();
        fragmentManager.beginTransaction().add(viewId, fragment).commit();
        return fragment;
    }
}
