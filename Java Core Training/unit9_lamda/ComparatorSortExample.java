package com.demo.unit9_lamda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortExample {
    public static void main(String[] args) {
        Integer[] values = {4, 6, 1, 3, 5, 2, 8, 9};
        example2(values);
        for (Integer value : values) {
            System.out.print(value + ", ");
        }
    }

    public static void example1(Integer[] values) {
        Arrays.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public static void example2(Integer[] values) {
        Arrays.sort(values, (Integer o1, Integer o2) -> (o1 - o2));
    }
}
