package com.demo.unit6_java_thread;

import java.util.Arrays;

public class ThreadExample {
    public static void main(String[] args) {
        new Thread(() -> {
            Arrays.stream(new String[]{"1", "Hello", "Tran", "2", "Phuong"})
                    .forEach(element -> {
                        try {
                            Thread.sleep(1000);
                            System.out.println(element);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
        }).start();
    }

}
