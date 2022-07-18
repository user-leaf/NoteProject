package com.bamboo.module_test2.test12_enum;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;

import java.util.Arrays;

public class EnumDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12_enum);

        EDay[] days = EDay.values();
        System.out.println("day: " + Arrays.toString(days));
        EDay monday = EDay.valueOf("MONDAY");
        System.out.println("day: " + monday);

        for (EDay day : EDay.values()) {
            System.out.println("day desc: " + day.getDesc());
        }
    }
}
