package com.note.light.chapter2;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.note.light.R;

import java.util.List;

public class MyRecyclerViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyRecyclerViewAdapter(@Nullable List<String> data) {
        super(R.layout.item_rv2, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tvTitle, item);
        TextView textView = helper.getView(R.id.tvTitle);
    }
}
