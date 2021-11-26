package com.sesame.noteproject.material_design;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sesame.noteproject.R;
import com.sesame.noteproject.utils.BarUtils;

import java.util.ArrayList;
import java.util.List;

public class MaterialDesignActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> mFragmentList = new ArrayList<>();

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MaterialDesignActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_material_design);
        setContentView(R.layout.activity_frg_md_container);

        MdFragment fragment = MdFragment.newInstance();
        Md2Fragment fragment2 = Md2Fragment.Companion.newInstance(); // why not object

        mFragmentList.add(fragment);
        mFragmentList.add(fragment2);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment).hide(fragment)
                .add(R.id.container, fragment2).hide(fragment2)
                .commit();

        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);

        showFragment(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                hideFragments();
                showFragment(0);
                break;

            case R.id.tv2:
                hideFragments();
                showFragment(1);
                break;
        }
    }

    private void showFragment(int i) {
        getSupportFragmentManager().beginTransaction()
                .show(mFragmentList.get(i))
                .commit();
    }

    private void hideFragments() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : mFragmentList) {
            transaction.hide(fragment);
        }
        transaction.commit();
    }
}
