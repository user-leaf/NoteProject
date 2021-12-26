package com.sesame.module_test.test_pickerview;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

import java.util.ArrayList;
import java.util.List;

public class PickerActivity extends AppCompatActivity {

    private List<Integer> options;
    private TextView tvShow;
    private SelectOptionPop optionDialog;
    private int selectPos = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_picker);
        tvShow = findViewById(R.id.tvShow);

        options = new ArrayList<>();
        options.add(R.string.option_data);
        options.add(R.string.option_event);
        options.add(R.string.option_holiday);

        initPickerView();
        findViewById(R.id.pickerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initOptionPop();
                optionDialog.show(getSupportFragmentManager(), "optionDialog");
            }
        });
    }

    private void initOptionPop() {
        optionDialog = new SelectOptionPop().setTabs(options, selectPos).setTabSelectListener(new SelectOptionPop.TabSelectListener() {
            @Override
            public void onSelected(int position, int itemValue) {
                selectPos = position;
                tvShow.setText(itemValue);
            }
        });
    }

    private void initPickerView() {
//
//
//        //条件选择器
//        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
//            @Override
//            public void onOptionsSelect(int options1, int option2, int options3, View v) {
//                //返回的分别是三个级别的选中位置
////                String tx = options1Items.get(options1).getPickerViewText()
////                        + options2Items.get(options1).get(option2)
////                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
//                tvShow.setText(options.get(options1));
//            }
//
//        }).build();
//        pvOptions.setNPicker(options, null, null);
    }
}
