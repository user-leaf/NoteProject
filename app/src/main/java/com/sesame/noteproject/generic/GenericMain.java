package com.sesame.noteproject.generic;

import android.util.Log;

public class GenericMain {

    public static void main(String[] args) {
        Generic generic = new Generic();
//        try {
//            Object object = generic.getObject(Class.forName("com.sesame.noteproject.generic.User"));
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        System.out.println("name: " + generic.getName(new User("vira", 18, 1000)));

        // 用idea去执行


    }
}
