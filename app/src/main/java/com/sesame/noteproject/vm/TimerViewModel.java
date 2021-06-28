package com.sesame.noteproject.vm;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {

    private static final String TAG = TimerViewModel.class.getSimpleName();
    private Timer timer;
    private int currentSecond;
    private OnTimeChangedListener onTimeChangedListener;

    public void startTiming() {
        if (timer == null) {
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    currentSecond++;
                    if (onTimeChangedListener != null) {
                        onTimeChangedListener.onTimeChanged(currentSecond);
                    }
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    public interface OnTimeChangedListener{
        void onTimeChanged(int second);
    }

    public void setOnTimeChangedListener(OnTimeChangedListener onTimeChangedListener){
        this.onTimeChangedListener = onTimeChangedListener;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        timer.cancel();
    }
}
