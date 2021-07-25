package com.sesame.noteproject.viewbinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;
import com.sesame.noteproject.databinding.ActivityViewbindingStudyBinding;

public class ViewBindingStudyJavaActivity extends AppCompatActivity {

    private ActivityViewbindingStudyBinding binding;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewbindingStudyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btn1.setText("刘德利");
        binding.btn2.setText("张三");
    }
}
