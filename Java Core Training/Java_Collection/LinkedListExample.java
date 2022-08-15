package com.demo.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        example1(new String[]{"Tran", "Duc", "Phuong"});
    }

    public static void example1(String[] args) {
        List<String> list = new LinkedList<>();

        for (String element : args) {
            list.add(element);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("=>" + iterator.next());
        }

        list = new LinkedList<>(Arrays.asList(args));
        list.forEach(System.out::println);
    }

}
