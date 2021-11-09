package com.sesame.noteproject.lazyfragment;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class LazyLoadViewPagerAdapter extends FragmentPagerAdapter {

    private final FragmentManager mFragmentManager;
    private final int mBehavior;
    private final List<LazyLoadFragment> mFragmentList;

    public LazyLoadViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<LazyLoadFragment> fragmentList) {
        super(fm, behavior);
        mFragmentManager = fm;
        mBehavior = behavior;
        mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
