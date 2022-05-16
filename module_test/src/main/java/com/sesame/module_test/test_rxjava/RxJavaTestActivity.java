package com.sesame.module_test.test_rxjava;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sesame.module_test.R;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class RxJavaTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rxjava);

        main(null);
    }

    public static void main(String[] args) {
//        Observable.combineLatest(
//                Observable.just(3L, 6L, 0L),
//                Observable.intervalRange(4, 5, 1, 1, TimeUnit.SECONDS),
//                new BiFunction<Long, Long, Long>() {
//                    @Override
//                    public Long apply(Long aLong, Long aLong2) throws Throwable {
//                        System.out.println("@@@要合并的数据分别是:" + aLong + "," + aLong2);
//                        return aLong + aLong2;
//                    }
//                }
//        ).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Throwable {
//                System.out.println("@@@最终合并的结果：" + aLong);
//            }
//        });

        Observable.just(4, 5).startWith(Observable.just(1, 2, 3)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {

            }
        });
    }
}
