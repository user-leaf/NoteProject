package com.sesame.module_kotlin.jetpack.databinding;

import android.graphics.Color;
import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import com.sesame.module_kotlin.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void setImage(AppCompatImageView imageView, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        } else {
            imageView.setBackgroundColor(Color.DKGRAY);
        }
    }

    // 方法重载
    @BindingAdapter("image")
    public static void setImage(AppCompatImageView imageView, int imageResource) {
        imageView.setImageResource(imageResource);
    }

    // 多参数重载
    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(AppCompatImageView imageView, String imageUrl, int imageResource) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        } else {
            imageView.setImageResource(imageResource);
        }
    }

}
