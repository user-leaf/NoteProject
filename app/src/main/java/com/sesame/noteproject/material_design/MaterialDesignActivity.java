package com.sesame.noteproject.material_design;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sesame.noteproject.R;
import com.sesame.noteproject.utils.BarUtils;

public class MaterialDesignActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, MaterialDesignActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_material_design);
        setContentView(R.layout.activity_frg_md_container);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MdFragment.newInstance())
                .commit();
    }
}
