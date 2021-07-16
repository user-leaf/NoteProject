package com.sesame.noteproject.callphone;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

// 管理UI Data
public class CallPhoneVm extends AndroidViewModel {
    private final Context context;
    private MutableLiveData<String> phoneInfo;

    public CallPhoneVm(@NonNull @NotNull Application application) {
        super(application);
        context = application;
    }

    public MutableLiveData<String> getPhoneInfo() {
        if (phoneInfo == null) {
            phoneInfo = new MutableLiveData<>();
            phoneInfo.setValue("");
        }
        return phoneInfo;
    }

    public void appendNum(String value) {
        phoneInfo.setValue(phoneInfo.getValue() + value);
    }

    public void backspace() {
        int length = phoneInfo.getValue().length();
        if (length > 0) {
            phoneInfo.setValue(phoneInfo.getValue().substring(0, length - 1));
        }
    }

    public void call() {
        Toast.makeText(context, "拨打电话" + phoneInfo.getValue(), Toast.LENGTH_SHORT).show();
    }

    public void clear() {
        phoneInfo.setValue("");
    }
}
