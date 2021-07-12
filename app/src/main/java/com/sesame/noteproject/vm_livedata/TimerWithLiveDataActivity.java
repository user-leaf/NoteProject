package com.sesame.noteproject.vm_livedata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sesame.noteproject.R;

public class TimerWithLiveDataActivity extends AppCompatActivity {

    private TimerWithLiveDataViewModel mTimerVM;
    private TextView mTvShow;

    public static void startActivity(Context context){
        context.startActivity(new Intent(context, TimerWithLiveDataActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_with_live_data);
        initView();
        initData();
    }

    private void initView() {
        mTvShow = findViewById(R.id.tvShow);
        mTimerVM = ViewModelProviders.of(this).get(TimerWithLiveDataViewModel.class);
    }

    private void initData() {
        mTimerVM.getCurrentSecond().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer second) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvShow.setText("ViewModel&LiveData Time: " + second);
                    }
                });
            }
        });

        findViewById(R.id.btnResetTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimerVM.getCurrentSecond().postValue(0);
            }
        });

        mTimerVM.startTiming();
    }
}
