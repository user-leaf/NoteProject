package com.sesame.module_test.test_main_switch_tabs;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sesame.module_test.R;

import java.util.ArrayList;
import java.util.List;

public class SwitchTabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_tabs);

        List<MyFragment> fragments = new ArrayList<>();
        fragments.add(MyFragment.newInstance("page1"));
        fragments.add(MyFragment.newInstance("page2"));
        fragments.add(MyFragment.newInstance("page3"));
        fragments.add(MyFragment.newInstance("page4"));

        ViewPager vpContent = findViewById(R.id.vpContent);
        vpContent.setOffscreenPageLimit(fragments.size());
        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        RadioGroup rgTabs = findViewById(R.id.rgTabs);
        rgTabs.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            int index = 0;
            switch (checkedId) {
                case R.id.rbTabQuotation:
                    index = 0;
                    break;
                case R.id.rbTabInfo:
                    index = 1;
                    break;
                case R.id.rbTabPosition:
                    index = 2;
                    break;
                case R.id.rbTabMine:
                    index = 3;
                    break;
            }

            vpContent.setCurrentItem(index);
        });
    }
}
