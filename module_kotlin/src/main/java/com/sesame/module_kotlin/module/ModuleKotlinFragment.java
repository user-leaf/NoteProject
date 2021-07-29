package com.sesame.module_kotlin.module;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sesame.module_kotlin.R;

public class ModuleKotlinFragment extends Fragment {

    public ModuleKotlinFragment() {
    }

    public static ModuleKotlinFragment newInstance() {
        ModuleKotlinFragment fragment = new ModuleKotlinFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_module_kotlin, container, false);
    }
}