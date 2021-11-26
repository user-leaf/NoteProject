package com.sesame.module_test.test_android_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.sesame.module_test.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Blank2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Blank2Fragment extends Fragment {

    private String mParam1 = "init1";
    private String mParam2 = "init2";
    private View mView;

    public Blank2Fragment() {
    }

    public Blank2Fragment(String param1, String param2) {
        mParam1 = param1;
        mParam2 = param2;
    }

//    public static Blank2Fragment newInstance(String param1, String param2) {
//        Blank2Fragment fragment = new Blank2Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_blank2, container, false);
        initView();
        return mView;
    }

    private void initView() {
        TextView tv1 = mView.findViewById(R.id.tv1);
        TextView tv2 = mView.findViewById(R.id.tv2);
        tv1.setText(mParam1);
        tv2.setText(mParam2);
    }

    @Override
    public void onDestroyView() {
        mParam1 = "destroy1";
        super.onDestroyView();
    }
}