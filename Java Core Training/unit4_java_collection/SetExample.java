package com.demo.unit4_java_collection;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);
        numbers.add(10);

        System.out.println("Size: " + numbers.size());
    }
}
