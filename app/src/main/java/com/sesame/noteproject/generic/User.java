package com.sesame.noteproject.generic;

public class User extends Person{

    private int userId;

    public User(String name, int age, int userId) {
        super(name, age);
        this.userId = userId;
    }
}
