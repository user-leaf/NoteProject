package com.bamboo.module_test2.test11_multilanguage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;
import com.orhanobut.hawk.Hawk;

public class MultiLanguageActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MultiLanguageActivity.class.getSimpleName();

    private final String[] cities = {"简体中文", "英文", "繁体中文", "韩文"};
    private final String[] locals = {"zh_CN", "en", "zh_TW", "ko"};
    private boolean[] choices = {true, false, true, false};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test11_multilanguage);

        findViewById(R.id.btnChangeLanguage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangeLanguage:
                AlertDialog.Builder builder = new AlertDialog.Builder(MultiLanguageActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("选择语言");
                builder.setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String languageType = locals[which];
                        changeAppLanguage(languageType);
                        recreate();
                        restartMultiLanguage(MultiLanguageActivity.this);
                    }
                });
                builder.show();
                break;
        }
    }

    private void changeAppLanguage(String languageType) {
        if (!TextUtils.isEmpty(languageType)) {
            int index = ELanguageType.English.getIndex();
            switch (languageType) {
                case "zh_CN":
                    index = ELanguageType.SimplifiedChinese.getIndex();
                    break;
                case "zh_TW":
                    index = ELanguageType.TraditionalChinese.getIndex();
                    break;
                case "en":
                case "en_US":
                    index = ELanguageType.English.getIndex();
                    break;
                case "ko":
                    index = ELanguageType.Korea.getIndex();
                    break;
            }
            LanguageUtils.setLanguage(this, index);
        }
    }

    private void restartMultiLanguage(Activity activity){
        if (!activity.isDestroyed()){
            Intent intent = new Intent(activity, MultiLanguageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
            activity.finish();
        }
    }
}
