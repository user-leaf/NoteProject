package com.note.light.chapter2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.note.light.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        Toolbar toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        mTabLayout = findViewById(R.id.tabLayout);
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.viewPager);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("精选a");
        titles.add("精选b");
        titles.add("精选c");
//        titles.add("精选d");
//        titles.add("精选e");
//        titles.add("精选f");
//        titles.add("精选g");
//        titles.add("精选h");
//        titles.add("精选i");
//        titles.add("精选j");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(ListFragment.newInstance(titles.get(i)));
        }

        /*
        1、ViewPager
        2、TabLayout
            title哪来的
            PagerAdapter有FragmentPagerAdapter和FragmentStatePagerAdapter
            FragmentPagerAdapter与FragmentStatePagerAdapter什么区别
         */

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
//        mTabLayout.setTabsFromPagerAdapter(viewPagerAdapter); //??

    }
}
