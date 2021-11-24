package com.sesame.noteproject.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl implements Observable {

    private List<Observer> mObservableList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        if (!mObservableList.contains(observer)) {
            mObservableList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (mObservableList.contains(observer)) {
            mObservableList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : mObservableList) {
            observer.changeAction("被观察者发生了变化");
        }
    }
}
