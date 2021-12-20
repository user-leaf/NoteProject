package com.note.light.chapter2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.note.light.R;
import com.note.light.chapter1.MyRvAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public static ListFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("param1", title);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_list, container, false);
        return mRecyclerView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String title = null;
        if (arguments != null) {
            title = arguments.getString("param1");
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(title + "-" + i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(strings));

    }
}
