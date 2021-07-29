package com.sesame.module_kotlin.jetpack.room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sesame.module_kotlin.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.Subject;

public class RoomDemoActivity extends AppCompatActivity implements View.OnClickListener {

//    private MyDatabase mMyDatabase;
    private RecyclerView mRecyclerView;
    private List<Student> mStudentList;
    private BaseQuickAdapter mAdapter;
    private TextView mTvShow;
    private Random mRandom;
    private StudentViewModel mStudentViewModel;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_room);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnUpdate).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnGetStudentList).setOnClickListener(this);
        findViewById(R.id.btnGetStudentById).setOnClickListener(this);
        mTvShow = findViewById(R.id.tvShow);
//        mMyDatabase = MyDatabase.getInstance(this);

        mStudentList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mAdapter = new BaseQuickAdapter(R.layout.item_room_demo, mStudentList) {

            @Override
            public void onBindViewHolder(@androidx.annotation.NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            protected void convert(@androidx.annotation.NonNull @NotNull BaseViewHolder helper, Object item) {
                helper.setText(R.id.tvStudentId, String.valueOf(((Student) item).id));
                helper.setText(R.id.tvStudentName, ((Student) item).name);
                helper.setText(R.id.tvStudentAge, ((Student) item).age);

            }
        };
        mRecyclerView.setAdapter(mAdapter);

        mRandom = new Random();

        mStudentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        mStudentViewModel.getLiveDataStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> list) {
                mStudentList.clear();
                mStudentList.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnAdd) {
            Observable.just(1)
                    .map(new Function<Integer, Object>() {
                        @Override
                        public Object apply(Integer integer) throws Throwable {
                            mStudentViewModel.getMyDatabase().studentDao().insertStudent(new Student("张三", "age:" + mRandom.nextInt(20)));
                            return 1;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableObserver<Object>() {
                        @Override
                        public void onNext(@NonNull Object o) {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

//                Observable.just(1)
//                        .map((Function<Integer, List<Student>>) integer -> {
//                            mStudent = new Student("张三", "age:" + mRandom.nextInt(20));
//                            mMyDatabase.studentDao().insertStudent(mStudent);
//                            List<Student> studentList = mMyDatabase.studentDao().getStudentList();
//                            return studentList;
//                        })
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new DisposableObserver<List<Student>>() {
//                            @Override
//                            public void onNext(@NonNull List<Student> list) {
//                                mStudentList.clear();
//                                mStudentList.addAll(list);
//                                mAdapter.notifyDataSetChanged();
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });
        } else if (id == R.id.btnUpdate) {
        } else if (id == R.id.btnDelete) {
        } else if (id == R.id.btnGetStudentList) {//                getStudentList();
        } else if (id == R.id.btnGetStudentById) {//                Executors.newSingleThreadExecutor().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        Student student = mMyDatabase.studentDao().getStudentById(5);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                mTvShow.setText("Age: " + student.age);
//                            }
//                        });
//                    }
//                });
        }
    }

//    private void getStudentList() {
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                List<Student> studentList = mMyDatabase.studentDao().getStudentList();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mStudentList.clear();
//                        mStudentList.addAll(studentList);
//                        mAdapter.notifyDataSetChanged();
//                    }
//                });
//            }
//        });
//    }
}
