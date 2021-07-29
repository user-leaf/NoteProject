package com.sesame.module_base;

import android.content.Context;
import android.widget.Toast;

public class EmptyTestService implements ITestService{

    @Override
    public void launch(Context context) {
        Toast.makeText(context, "空", Toast.LENGTH_SHORT).show();
    }
}
