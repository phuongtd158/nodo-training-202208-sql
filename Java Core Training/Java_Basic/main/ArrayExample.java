package com.demo.main;

public class ArrayExample {
    public static void main(String[] args) {
        //example1();
        example2(new Integer[]{1, 4, 5, 3, 5, 6, 10});
    }

    public static void example1() {
        float[] values = {4.5f, 5.5f};
        float total = 0;

        for (float value : values) {
            total += value;
        }

        System.out.println("Total value of array is: " + total);
    }

    public static void example2(Integer[] args) {
        int total = 0;
        int max = args[0];

        for (int i = 0; i < args.length; i++) {
            total += args[i];
        }

        System.out.println("Total value of array is: " + total);

        for (int i = 0; i < args.length; i++) {
            if (args[i] > max) {
                max = args[i];
            }
        }

        System.out.println("Max value of array is: " + max);
    }
}
