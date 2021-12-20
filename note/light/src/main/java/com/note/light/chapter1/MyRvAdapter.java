package com.note.light.chapter1;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.note.light.R;

import java.util.List;

public class MyRvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyRvAdapter(@Nullable List<String> data) {
        super(R.layout.item_rv, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tvTitle, item);
        TextView textView = helper.getView(R.id.tvTitle);
        textView.getLayoutParams().height = (int) (100 + Math.random() * 300);
    }
}
