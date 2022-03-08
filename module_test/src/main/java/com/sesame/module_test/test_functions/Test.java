package com.sesame.module_test.test_functions;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        HelperKt.doSomething();

        ArrayList list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add(6);

        HelperKt.exchange(list, 1, 2);

        System.out.println("list in java: " + list);

        boolean isEven = HelperKt.getSumIsEven(list);
        System.out.println("isEven: " + isEven);
    }
}
