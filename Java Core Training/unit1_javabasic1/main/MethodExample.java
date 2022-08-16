package com.demo.unit1_javabasic1.main;

public class MethodExample {
    public static void main(String[] args) {

//        System.out.println("(4 + 7) = " + exampleAdd(4, 7));
//
//        int value1 = Integer.parseInt(args[0]);
//        int value2 = Integer.parseInt(args[1]);
//
//        System.out.println(value1 + " + " + value2 + " = " + exampleAdd(value1, value2));

        System.out.println(exampleAdd2(1, 2, 4, 5));
    }

    public static int exampleAdd(int number1, int number2) {
        return number1 + number2;
    }

    private static int exampleAdd2(int... values) {
        int total = 0;

        for (Integer value : values) {
            total += value;
        }

        return total;
    }
}
