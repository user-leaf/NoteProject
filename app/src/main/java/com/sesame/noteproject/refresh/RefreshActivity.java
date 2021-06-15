package com.sesame.noteproject.refresh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.sesame.noteproject.R;
import com.sesame.noteproject.refresh.views.ItemActivity;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RefreshActivity extends AppCompatActivity {

    private enum Item {
        Aty01(R.string.refresh_item_page_title1, ItemActivity.class),
        Aty02(R.string.refresh_item_page_title2, ItemActivity.class),
        Aty03(R.string.refresh_item_page_title3, ItemActivity.class),
        ;

        public int nameId;
        public Class<?> clazz;

        Item(@StringRes int nameId, Class<?> clazz) {
            this.nameId = nameId;
            this.clazz = clazz;
        }
    }

    private RecyclerView mRecyclerView;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, RefreshActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initRecyclerView();
        initRefresh();
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new BaseQuickAdapter<Item, BaseViewHolder>(R.layout.item_refresh_list, Arrays.asList(Item.values())) {
            @Override
            protected void convert(@NonNull @NotNull BaseViewHolder helper, Item item) {
                helper.setText(R.id.text1, item.nameId);
                helper.setText(R.id.text2, "sub-" + getString(item.nameId));
                helper.setTextColor(R.id.text2, getResources().getColor(R.color.colorAccent));
            }
        });
    }

    private void initRefresh() {
        RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        LottieRefreshHeader header = new LottieRefreshHeader(this);
        header.setRefreshBackground();
        refreshLayout.setRefreshHeader(header);
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

    }
}
