package com.sesame.module_kotlin.jetpack.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private final MyDatabase mMyDatabase;
    private LiveData<List<Student>> liveDataStudent;

    public StudentViewModel(@NonNull @NotNull Application application) {
        super(application);
        mMyDatabase = MyDatabase.getInstance(application);
        liveDataStudent = mMyDatabase.studentDao().getStudentList();
    }

    public LiveData<List<Student>> getLiveDataStudent() {
        return liveDataStudent;
    }

    public MyDatabase getMyDatabase() {
        return mMyDatabase;
    }
}
