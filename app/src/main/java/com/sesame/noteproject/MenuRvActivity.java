package com.sesame.noteproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sesame.noteproject.merge.MergeActivity;
import com.sesame.noteproject.test_company.TitleActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MenuRvActivity extends AppCompatActivity {

    private enum MenuItem {
        Merge("Merge", MergeActivity.class),
        Title("Title", TitleActivity.class),

        ;

        private String title;
        private Class clazz;
        private static List<String> titles = new ArrayList<>();

        MenuItem(String title, Class clazz) {
            this.title = title;
            this.clazz = clazz;
        }

        public static List<String> getTitles() {
            titles.clear();
            for (MenuItem item : MenuItem.values()) {
                titles.add(item.title);
            }
            return titles;
        }
    }


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        initRv();
    }

    private void initRv() {
        RecyclerView rv = findViewById(R.id.rvRoot);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<String> data = MenuItem.getTitles();
        BaseQuickAdapter<String, BaseViewHolder> adapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_menu_rv, data) {

            @Override
            protected void convert(@NonNull @NotNull BaseViewHolder helper, String item) {
                helper.setText(R.id.tvMenu, item);
                helper.setBackgroundColor(R.id.tvMenu, helper.getLayoutPosition() % 2 == 0 ? 0xff99cc00 : 0xffffbb33);
            }
        };
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MenuRvActivity.this, MenuItem.values()[position].clazz));
            }
        });
    }

}
