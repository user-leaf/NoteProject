package com.sesame.noteproject.lazyfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sesame.noteproject.R;

/*
https://www.cnblogs.com/Robin132929/p/13819386.html
一般我们在使用add+show+hide去显示、隐藏fragment或者fragment嵌套使用、viewpager+fragment结合使用等场景下，
如果不进行懒加载会导致多个fragment页面的生命周期被调用，每个页面都进行网络请求这样会产生很多无用的请求，因为实际
显示的只是用户看到的那个页面，其他页面没有必要在这个时候去加载数据。
 */
public class LazyLoadFragment extends Fragment {

    public static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private boolean isLoad = false;

    public LazyLoadFragment() {
    }

    public static LazyLoadFragment newInstance(String param1) {
        LazyLoadFragment fragment = new LazyLoadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lazyload, container, false);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(mParam1);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("fragment resume()--" + mParam1);

        if (!isLoad) {
            lazyLoad();
            isLoad = true;
        }
    }

    private void lazyLoad() {
        // 懒加载...
        System.out.println("fragment懒加载--" + mParam1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoad = false;
    }
}
