package com.bamboo.nano.list.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bamboo.nano.R;
import com.bamboo.nano.list.model.QuotationModel;
import com.bamboo.nano.list.widget.OrderView;
import com.bamboo.nano.list.widget.QuotationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class QuotationAdapter extends BaseQuickAdapter<QuotationModel, BaseViewHolder> {

    public QuotationAdapter(@Nullable List<QuotationModel> data) {
        super(R.layout.item_quotation, data);
    }

//    @Override
//    public int getItemViewType(int position) {
//        // 解决RecyclerView复用导致的数据错乱  why?
//        // 这种方法导致不能复用？个人感觉，既然是复用，就在控件使用前重置控件为初始状态。
//        // https://www.cnblogs.com/Ricardoldc/p/10345635.html
//        return position;
//    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, QuotationModel item) {
        QuotationView quotationView = helper.getView(R.id.quotationView);
        OrderView orderView = helper.getView(R.id.orderView);
        quotationView.setVisibility(View.GONE);
        orderView.setVisibility(View.GONE);
        switch (item.getType()) {
            case 0:
                quotationView.setTitle(item.getTitle());
                quotationView.setVisibility(View.VISIBLE);
                break;
            case 1:
                orderView.setTitle(item.getTitle());
                orderView.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }

        if ("expand".equals(payloads.get(0))) {
            View chartView = holder.getView(R.id.chartView);
            chartView.setVisibility(chartView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        }
    }
}
