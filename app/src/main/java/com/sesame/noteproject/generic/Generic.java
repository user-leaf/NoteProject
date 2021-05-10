package com.sesame.noteproject.generic;

public class Generic {

    public <T extends Person> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }

    public <T extends Person> String getName(T t){
        return t.getName();
    }

}
