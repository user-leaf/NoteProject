package com.sesame.noteproject.flexbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sesame.noteproject.R;

import java.util.List;

public class RvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RvAdapter(@Nullable List<String> data) {
        super(R.layout.item_rv_flexbox, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tvName, item);
    }
}
