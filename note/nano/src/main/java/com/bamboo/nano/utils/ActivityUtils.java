package com.bamboo.nano.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ActivityUtils {

    private static volatile ActivityUtils singleton;
    private Stack<WeakReference<Activity>> activities = new Stack<>();
    private Application application;

    private ActivityUtils() {
    }

    private ActivityUtils(Application application) {
        this.application = application;
        register();
    }

    private void register() {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                activities.push(new WeakReference<>(activity));
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                remove(activity);
            }
        });
    }

    public static void init(Application application) {
        if (singleton == null) {
            synchronized (ActivityUtils.class) {
                if (singleton == null) {
                    singleton = new ActivityUtils(application);
                }
            }
        }
    }

    private void remove(Activity activity) {
        Iterator<WeakReference<Activity>> iterator = activities.iterator();
        while (iterator.hasNext()){
            if (iterator.next().get() == activity){
                iterator.remove();
            }
        }
    }

    private void comeToActive(List<String> activityNames) {
        while (!activities.isEmpty()) {
            WeakReference<Activity> peek = activities.peek();
            if (peek.get() != null) {
                if (activityNames.contains(peek.get().getClass().getSimpleName())) {
                    return;
                } else {
                    WeakReference<Activity> popActivity = activities.pop();
                    if (popActivity.get() != null) {
                        popActivity.get().finish();
                    }
                }
            } else {
                activities.pop();
            }
        }
    }
}