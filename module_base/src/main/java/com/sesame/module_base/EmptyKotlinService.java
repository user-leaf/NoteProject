package com.sesame.module_base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class EmptyKotlinService implements IKotlinService {

    @Override
    public void launch(Context context) {
        Toast.makeText(context, "空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Fragment getFragment(FragmentManager fragmentManager, int viewId, Bundle bundle) {
        return null;
    }
}
