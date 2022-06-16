package com.bamboo.module_test2.test4_kotlin_check;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sesame.module_base.utils.FileUtils;

import java.lang.reflect.Type;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4_kotlin_check);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = FileUtils.getJson(TestActivity.this, "data.json");
                Type type = new TypeToken<BaseModel<List<PersonModel>>>() {
                }.getType();
                BaseModel<List<PersonModel>> model = new Gson().fromJson(json, type);
                System.out.println("@@@" + model.getValue().get(0).getName());
            }
        }).start();
    }
}
