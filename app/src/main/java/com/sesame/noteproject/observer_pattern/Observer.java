package com.sesame.noteproject.observer_pattern;

public interface Observer {
    <T> void changeAction(T observer);
}
