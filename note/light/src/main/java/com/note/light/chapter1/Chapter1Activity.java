package com.note.light.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.note.light.R;

import java.util.ArrayList;

public class Chapter1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);
        ImageView iv = findViewById(R.id.iv);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrantSwatch.getRgb()));
            }
        });

        initRv();

    }

    private void initRv() {
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("item-" + i);
        }
        rv.setAdapter(new MyRvAdapter(strings));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL | DividerItemDecoration.HORIZONTAL));
    }
}
