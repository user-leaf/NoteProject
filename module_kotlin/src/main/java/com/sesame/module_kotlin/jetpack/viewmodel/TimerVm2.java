package com.sesame.module_kotlin.jetpack.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TimerVm2 extends ViewModel {

    private int currentTime;
    private Observable<Long> mObservable;
    private OnTimerCallback mOnTimerCallback;

    public void startTimer() {
        if (mObservable == null) {
            mObservable = Observable.interval(0, 1, TimeUnit.SECONDS);
            mObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<Long>() {
                        @Override
                        public void onNext(@NonNull Long aLong) {
                            mOnTimerCallback.onTimeChanged(currentTime++);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    public void setOnTimerCallback(OnTimerCallback callback) {
        mOnTimerCallback = callback;
    }
}
