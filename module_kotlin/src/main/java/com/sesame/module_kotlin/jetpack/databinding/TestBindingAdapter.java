//package com.sesame.module_kotlin.jetpack.databinding;
//
//import android.graphics.Color;
//import android.text.TextUtils;
//
//import androidx.appcompat.widget.AppCompatImageView;
//import androidx.databinding.BindingAdapter;
//
//import com.sesame.module_kotlin.R;
//import com.squareup.picasso.Picasso;
//
//public class TestBindingAdapter {
//    // 与类名无关，静态方法，能调用到这个方法就行
//    @BindingAdapter("image")
//    public static void setImage(AppCompatImageView imageView, String imageUrl) {
//        if (!TextUtils.isEmpty(imageUrl)) {
//            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_foreground)
//                    .into(imageView);
//        } else {
//            imageView.setBackgroundColor(Color.DKGRAY);
//        }
//    }
//}
