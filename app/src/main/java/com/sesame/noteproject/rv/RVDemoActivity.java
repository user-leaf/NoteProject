package com.sesame.noteproject.rv;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sesame.noteproject.R;

import java.util.ArrayList;
import java.util.List;

public class RVDemoActivity extends AppCompatActivity {
    private List<Person> mPersonList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_demo);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(this, mPersonList);
        recyclerView.setAdapter(mAdapter);
        // 如果高度固定，可以设置setHasFixedSize(true)来避免requestLayout浪费资源，否则每次更新数据都会重新测量高度。
        recyclerView.setHasFixedSize(true);

        for (int i = 0; i < 20; i++) {
            Person person = new Person("person-" + i, i);
            mPersonList.add(person);
        }

        mAdapter.notifyDataSetChanged();
    }

    public void payload(View view) {
        mAdapter.notifyItemChanged(5, "changeText");
    }
}
