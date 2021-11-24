package com.sesame.noteproject.observer_pattern;

public class TestClient {
    public static void main(String[] args) {
        Observable observable = new ObservableImpl();

        Observer observer_1 = new ObserverImpl();
        Observer observer_2 = new ObserverImpl();
        Observer observer_3 = new ObserverImpl();
        Observer observer_4 = new ObserverImpl();
        Observer observer_5 = new ObserverImpl();

        observable.registerObserver(observer_1);
        observable.registerObserver(observer_2);
        observable.registerObserver(observer_3);
        observable.registerObserver(observer_4);
        observable.registerObserver(observer_5);

        observable.notifyObservers();
    }
}
