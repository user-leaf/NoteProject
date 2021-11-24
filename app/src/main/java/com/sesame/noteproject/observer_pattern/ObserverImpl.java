package com.sesame.noteproject.observer_pattern;

public class ObserverImpl implements Observer {

    @Override
    public <T> void changeAction(T observerInfo) {
        System.out.println(observerInfo.toString());
    }
}
