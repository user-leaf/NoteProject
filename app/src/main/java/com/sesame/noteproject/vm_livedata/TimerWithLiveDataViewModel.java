package com.sesame.noteproject.vm_livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerWithLiveDataViewModel extends ViewModel {

    private MutableLiveData<Integer> currentSecond = new MutableLiveData<>();
    private Timer timer;

    public LiveData<Integer> getCurrentSecond() {
//        if (currentSecond == null) {
//            currentSecond = new MutableLiveData<>();
//        }
        return currentSecond;
    }

    public void startTiming() {
        if (timer == null) {
            timer = new Timer();
            currentSecond.setValue(0);
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    if (currentSecond != null) {
                        currentSecond.postValue(currentSecond.getValue() + 1);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }
}
