package com.sesame.module_kotlin.jetpack.databinding.twowaybinding;

import androidx.databinding.ObservableField;

public class TwoWayBindingFieldViewModel {

    private ObservableField<LoginModel> mLoginModelObservableField;

    public TwoWayBindingFieldViewModel() {
        LoginModel loginModel = new LoginModel();
        loginModel.userName = "ZhangSan";
        mLoginModelObservableField = new ObservableField<>();
        mLoginModelObservableField.set(loginModel);
    }

    public String getUserName() {
        return mLoginModelObservableField.get().userName;
    }

    public void setUserName(String userName) {
        mLoginModelObservableField.get().userName = userName;
    }
}
