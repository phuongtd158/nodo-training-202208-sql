package com.demo.unit10_java_collection_2;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(30);

        new Thread(() -> addData(list)).start();
        new Thread(() -> printData(list)).start();
    }

    public static void addData(List<Integer> list) {
        while (true) {
            int random = (int) (Math.random() * 1000);
            list.add(random);
            System.out.println("Add new data: " + random);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printData(List<Integer> list) {
        while (true) {
            try {
                System.out.println("=====================");
                list.forEach(value -> {
                    System.out.println("Value: " + value);
                    try {
                        Thread.sleep(80L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
