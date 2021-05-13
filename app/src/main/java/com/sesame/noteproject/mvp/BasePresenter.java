package com.sesame.noteproject.mvp;

import android.view.View;

import androidx.fragment.app.Fragment;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter<T extends View> extends Fragment {

    protected Reference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    public T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
