package com.sesame.noteproject;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sesame.noteproject.arouter.VRouterPath;
import com.sesame.noteproject.deeplink.advanced.DeeplinkModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DeeplinkManager {

    private static final String TAG = DeeplinkManager.class.getSimpleName();
    private static volatile DeeplinkManager singleton;

    private List<DeeplinkModel> mDeeplinkModelList = new ArrayList<>();

    private DeeplinkManager() {
    }

    public static DeeplinkManager getInstance() {
        if (singleton == null) {
            synchronized (DeeplinkManager.class) {
                if (singleton == null) {
                    singleton = new DeeplinkManager();
                }
            }
        }
        return singleton;
    }

    public void init(Application application) {
        String json = "";
        String fileName = "page_router.json";
        try {
            InputStream is = application.getAssets().open(fileName);
            int length = is.available();
            byte[] buffer = new byte[length];
            is.read(buffer);
            json = new String(buffer, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<DeeplinkModel>>() {
        }.getType();
        mDeeplinkModelList = new Gson().fromJson(json, type);
    }

    public boolean handlingUrls(Context context, Uri uri) {
        for (DeeplinkModel item : mDeeplinkModelList) {
            if (uri.getLastPathSegment().equals(item.activity)) {
                determinateAction(context, item);
                return true;
            }
        }
        return false;
    }

    private void determinateAction(Context context, DeeplinkModel deeplinkModel) {
        if ("goal".equals(deeplinkModel.activity)) {
            ARouter.getInstance().build(VRouterPath.Activity_Deeplink_Goal)
                    .navigation(context);
        }
        Log.d(TAG, "determinateAction: ");
    }
}