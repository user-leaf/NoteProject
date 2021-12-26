package com.sesame.module_test.test_pickerview;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.sesame.module_test.R;

import java.lang.reflect.Field;
import java.util.List;

import top.defaults.view.PickerView;
import top.defaults.view.PickerViewDialog;

public class SelectOptionPop extends DialogFragment {

    private int position = 0;
    private List<Integer> tabs;
    private PickerView pickerView;
    private TabSelectListener mTabSelectListener;
    private int mOldUiFlag;


    public SelectOptionPop setTabSelectListener(TabSelectListener mTabSelectListener) {
        this.mTabSelectListener = mTabSelectListener;
        return this;
    }

    public SelectOptionPop setTabs(List<Integer> tabs, int selectPos) {
        this.tabs = tabs;
        if (selectPos > 0) {
            this.position = selectPos;
        }
        return this;
    }

    private PickerView.Adapter pickerAdapter = new PickerView.Adapter() {
        @Override
        public int getItemCount() {
            return tabs == null ? 0 : tabs.size();
        }

        @Override
        public PickerView.PickerItem getItem(int index) {
            return new PickerView.PickerItem() {
                @Override
                public String getText() {
                    return getString(tabs.get(index));
                }
            };
        }

    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        PickerViewDialog dialog = new PickerViewDialog(getActivity());

        dialog.setContentView(R.layout.layout_tab_pop);
        mOldUiFlag = getActivity().getWindow().getDecorView().getSystemUiVisibility();
        pickerView = dialog.findViewById(R.id.pickerView);
        pickerView.setItemHeight(getContext().getResources().getDimensionPixelSize(R.dimen.picker_text_height));
        pickerView.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.picker_text_size));
        pickerView.setAdapter(pickerAdapter);

        View.OnClickListener onClickListener = v -> {
            if (v.getId() == R.id.btn_picker_cancel) {
                dialog.dismiss();
            } else if (v.getId() == R.id.btn_picker_done) {
                if (mTabSelectListener != null) {
                    mTabSelectListener.onSelected(pickerView.getSelectedItemPosition(), tabs.get(pickerView.getSelectedItemPosition()));
                }
                if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                } else {
                    getActivity().getWindow().getDecorView().setSystemUiVisibility(mOldUiFlag);
                }

                dialog.dismiss();
            }
        };
        dialog.findViewById(R.id.btn_picker_cancel).setOnClickListener(onClickListener);
        dialog.findViewById(R.id.btn_picker_done).setOnClickListener(onClickListener);
        pickerView.getAdapter().notifyDataSetChanged();
        pickerView.setSelectedItemPosition(position);
        return dialog;

    }

    @Override
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        try {
            if (this.getClass().getSuperclass() != null) {
                Field mDismissed = this.getClass().getSuperclass().getDeclaredField("mDismissed");
                Field mShownByMe = this.getClass().getSuperclass().getDeclaredField("mShownByMe");
                mDismissed.setAccessible(true);
                mShownByMe.setAccessible(true);
                mDismissed.setBoolean(this, false);
                mShownByMe.setBoolean(this, true);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

    public interface TabSelectListener {
        void onSelected(int position, int itemValue);
    }
}
