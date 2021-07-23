package com.sesame.module_kotlin.jetpack.databinding.twowaybinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.sesame.module_kotlin.BR;

public class TwoWayBindingViewModel extends BaseObservable {
    private LoginModel mLoginModel;

    public TwoWayBindingViewModel() {
        mLoginModel = new LoginModel();
        mLoginModel.userName = "Michael";
    }

    @Bindable
    public String getUserName() {
        return mLoginModel.userName;
    }

    public void setUserName(String userName) {
        if (userName != null && !userName.equals(mLoginModel.userName)) {
            mLoginModel.userName = userName;
            notifyPropertyChanged(BR.userName);
        }
    }
}
