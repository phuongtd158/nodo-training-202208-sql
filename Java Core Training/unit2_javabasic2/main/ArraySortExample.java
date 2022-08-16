package com.demo.unit2_javabasic2.main;

import java.util.Arrays;

public class ArraySortExample {
    public static void main(String[] args) {
        String[] arr = {"1", "4", "0", "8", "5", "6"};

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();

        Arrays.sort(arr, ((o1, o2) -> o2.compareTo(o1)));

        for (String value : arr) {
            System.out.println(value + ", ");
        }
    }
}
