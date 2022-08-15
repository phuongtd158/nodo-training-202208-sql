package com.demo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionExample {
    public static void main(String[] args) {
        example2("3", "2", "1", "0");
    }

    public static void example1() {
        Short[] values = {1, 4, 2, 0, 5, 7};
        List<Short> list = new ArrayList<>();

        Collections.addAll(list, values);
        Collections.reverse(list);

        list.toArray(values);
        for (Short value : values) {
            System.out.println(value);
        }
    }

    public static void example2(String... args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, args);
        Collections.sort(list);

        for (String element : list) {
            System.out.println(element);
        }

        System.out.println("Index: " + Collections.binarySearch(list, "1"));
    }

}
