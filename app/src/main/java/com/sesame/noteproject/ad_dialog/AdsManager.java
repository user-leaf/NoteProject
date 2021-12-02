package com.sesame.noteproject.ad_dialog;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sesame.noteproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kotlin.text.Charsets;

public class AdsManager {

    private static volatile AdsManager singleton;

    private List<AdInfo> mAdInfoList = new ArrayList<>();
    private Context mContext;

    private AdsManager() {
    }

    private AdsManager(Context context) {
        init(context);
        mContext = context;
    }

    private void init(Context context) {
        String json = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("data_splash_ad.json");
            int length = inputStream.available();
            byte[] buffer = new byte[length];
            inputStream.read(buffer);
            json = new String(buffer, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mAdInfoList = new Gson().fromJson(json, BaseInfo.class).getData();
    }

    public static AdsManager getInstance(Context context) {
        if (singleton == null) {
            synchronized (AdsManager.class) {
                if (singleton == null) {
                    singleton = new AdsManager(context);
                }
            }
        }
        return singleton;
    }

    public void showAd() {
        if (mAdInfoList == null || mAdInfoList.isEmpty()) {
            return;
        }
        AdInfo adInfo = mAdInfoList.get(0);
        mAdInfoList.remove(0);
        if ("text".equals(adInfo.getType())) {
            showTextAd(adInfo);
        } else if ("image".equals(adInfo.getType())) {
            showImageAd(adInfo);
        }
    }

    private void showTextAd(AdInfo adInfo) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_ad_text, null, false);
        AlertDialog dialog = new AlertDialog.Builder(mContext).setView(view).create();
        TextView tvContent = view.findViewById(R.id.tvContent);
        tvContent.setText(adInfo.getContent());
        view.findViewById(R.id.btnCommit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showAd();
            }
        });
        dialog.show();
    }

    private void showImageAd(AdInfo adInfo) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_ad_img, null, false);
        AlertDialog dialog = new AlertDialog.Builder(mContext).setView(view).create();
        ImageView ivAd = view.findViewById(R.id.ivAd);
        Glide.with(mContext).load(adInfo.getImgUrl()).into(ivAd);
        view.findViewById(R.id.btnCommit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                showAd();
            }
        });
        dialog.show();
    }
}