package com.sesame.module_test.test_android;

import android.app.Fragment;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

/**
 * Fragment的构造函数为啥不让传参？（B站）
 * fragment页面重叠问题
 */
public class ArgumentActivity extends AppCompatActivity {

    private BlankFragment mBlankFragment;
    private Blank2Fragment mBlank2Fragment;

    private static final String TAG1 = "fragment_1";
    private static final String TAG2 = "fragment_2";

    private final String KEY1 = "key_1";
    private final String KEY2 = "key_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argument);

        if (savedInstanceState != null) {
            mBlankFragment = (BlankFragment) getSupportFragmentManager().getFragment(savedInstanceState, KEY1);
            mBlank2Fragment = (Blank2Fragment) getSupportFragmentManager().getFragment(savedInstanceState, KEY2);
        } else {
            mBlankFragment = BlankFragment.newInstance("aaa", "bbb");

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mBlankFragment)
                    .show(mBlankFragment)
                    .commit();

            mBlank2Fragment = new Blank2Fragment("111", "222");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container2, mBlank2Fragment)
                    .show(mBlank2Fragment)
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // https://blog.csdn.net/yuzhiqiang_1993/article/details/75014591

        if (mBlankFragment != null) {
            getSupportFragmentManager().putFragment(outState, KEY1, mBlankFragment);
        }

        if (mBlank2Fragment != null) {
            getSupportFragmentManager().putFragment(outState, KEY2, mBlank2Fragment);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}