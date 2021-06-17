package com.sesame.noteproject.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.sesame.noteproject.BR;

public class User extends BaseObservable {
    private String name;
    private String psw;

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
        notifyPropertyChanged(BR.psw);
    }
}
