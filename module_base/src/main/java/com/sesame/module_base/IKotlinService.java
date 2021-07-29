package com.sesame.module_base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public interface IKotlinService {
    void launch(Context context);
    Fragment getFragment(FragmentManager fragmentManager, int viewId, Bundle bundle);
}
