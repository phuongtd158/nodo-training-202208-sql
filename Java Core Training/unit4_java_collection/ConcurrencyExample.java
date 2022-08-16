package com.demo.unit4_java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyExample {

    public static void main(String[] args) {
        //example1();
        //example2();
        example3();
    }

    public static void example1() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 6, 4, 9, 8);

        System.out.println("Before remove: size of list = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }
        System.out.println("After remove: size of list = " + list.size());
    }

    public static void example2() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 6, 4, 9, 8);

        System.out.println("Before remove: size of list = " + list.size());
        list.forEach(element -> {
            if (element == 2) {
                list.remove(element);
            }
        });
        System.out.println("After remove: size of list = " + list.size());
    }

    public static void example3() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 6, 4, 9, 8);
        Iterator<Integer> iterator = list.iterator();

        System.out.println("Before remove: size of list = " + list.size());

        while (iterator.hasNext()) {
            if (iterator.next() == 2) {
                iterator.remove();
            }
        }

        list.removeIf(item -> item == 4);

        list.removeAll(Collections.singleton(9));

        System.out.println("After remove: size of list = " + list.size());
    }
}
