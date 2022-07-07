package com.bamboo.module_test2.test8_try_catch;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bamboo.module_test2.R;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TryCatchActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test8_try_catch);

        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnStart2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                String str = null;
                try {
                    if (true) {
                        str.toString();
                    }
                } catch (Exception e) {
                    System.out.println("catch");
                } finally {
                    System.out.println("finally");
                }
                break;

            case R.id.btnStart2:
                Observable.just(1)
                        .map(new Function<Integer, String>() {
                            @Override
                            public String apply(Integer integer) throws Throwable {
                                String str = null;
                                if (true) {
                                    str.toString();
                                }
                                return "hello";
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                System.out.println("onSubscribe");
                            }

                            @Override
                            public void onNext(@NonNull String s) {
                                System.out.println("onNext: " + s);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                System.out.println("onError");
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("onComplete");
                            }
                        });
                break;
        }
    }
}
