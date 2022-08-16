package com.demo.unit2_javabasic2.main;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExample {
    public static void main(String[] args) {
        System.out.println(countDigit2("1 Tran Duc Phuong 2002"));
    }

    public static int countDigit(String value) {

        int i = 0;
        int counter = 0;

        while (i < value.length()) {
            char c = value.charAt(i);
            if (Character.isDigit(c)) {
                counter++;
            }
            i++;
        }
        return counter;
    }

    public static int countDigit2(String value) {
        AtomicInteger counter = new AtomicInteger(0);
        IntStream stream = value.chars();

        stream.forEach(c -> {
            if (Character.isDigit(c)) {
                counter.incrementAndGet();
            }
        });

        return counter.get();
    }
}
