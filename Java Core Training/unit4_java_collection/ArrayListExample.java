package com.demo.unit4_java_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListExample {
    public static void main(String[] args) {
        example1(new String[]{"1", "2", "3", "4"});
    }

    public static void example1(String[] args) {
        List<String> list = new ArrayList<>();

        Collections.addAll(list, args);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at " + i + " is: " + list.get(i));
        }

        IntStream.range(0, list.size()).forEach(i -> {
            System.out.println("Element at " + i + " is: " + list.get(i));
        });
    }
}
