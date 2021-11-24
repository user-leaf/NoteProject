package com.sesame.noteproject.observer_pattern;

public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
