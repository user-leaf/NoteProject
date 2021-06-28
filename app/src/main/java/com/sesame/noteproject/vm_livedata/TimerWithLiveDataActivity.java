package com.sesame.noteproject.vm_livedata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sesame.noteproject.R;

public class TimerWithLiveDataActivity extends AppCompatActivity {

    public static void startActivity(Context context){
        context.startActivity(new Intent(context, TimerWithLiveDataActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_with_live_data);

        TextView tvShow = findViewById(R.id.tvShow);
        TimerWithLiveDataViewModel viewModel = ViewModelProviders.of(this).get(TimerWithLiveDataViewModel.class);
        MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) viewModel.getCurrentSecond();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer second) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvShow.setText("ViewModel&LiveData Time: " + second);
                    }
                });
            }
        });

        findViewById(R.id.btnResetTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveData.setValue(0);
            }
        });

        viewModel.startTiming();
    }
}
