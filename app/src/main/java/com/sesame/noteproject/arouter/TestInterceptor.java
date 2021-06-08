//package com.sesame.noteproject.arouter;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.alibaba.android.arouter.facade.Postcard;
//import com.alibaba.android.arouter.facade.annotation.Interceptor;
//import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
//import com.alibaba.android.arouter.facade.template.IInterceptor;
//
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Single;
//import io.reactivex.rxjava3.core.SingleObserver;
//import io.reactivex.rxjava3.disposables.Disposable;
//
//@Interceptor(priority = 8, name = "测试用拦截器")
//public class TestInterceptor implements IInterceptor {
//    private static final String TAG = TestInterceptor.class.getSimpleName();
//    private Context mContext;
//
//    @Override
//    public void process(Postcard postcard, InterceptorCallback callback) {
//        boolean isLogin = false;
//        if (isLogin) {
//            callback.onContinue(postcard);
//        } else {
//            // 拦截器都是运行在ARouter内部的一个子线程池中的
//            Single.just(1)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new SingleObserver<Integer>() {
//                        @Override
//                        public void onSubscribe(@NonNull Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onSuccess(@NonNull Integer integer) {
//                            Toast.makeText(mContext, "onSuccess", Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onError(@NonNull Throwable e) {
//
//                        }
//                    });
//            callback.onInterrupt(null);
//        }
//
//    }
//
//    @Override
//    public void init(Context context) {
//        mContext = context;
//    }
//}
