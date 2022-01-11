package com.sesame.module_test.test_main_switch_tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sesame.module_test.R;

public class MyFragment extends Fragment {

    private TextView tvTitle;
    private String title;

    public static MyFragment newInstance(String title) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", title);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString("param1");
        }
        System.out.println("@@@ onCreate: " + title);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_test_switch_tab, container, false);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("@@@ onResume: " + title);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        System.out.println("@@@ onHiddenChanged: " + title+", hidden: "+hidden);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("@@@ onDestroy: "+title);
    }
}
