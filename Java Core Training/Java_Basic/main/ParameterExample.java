package com.demo.main;

import java.util.Arrays;

public class ParameterExample {

    public static void main(String[] args) {
        //helloWorld();
        //example2(new String[]{"Say", "goodbye", "to", "you"});
        //example3(new String[]{"Tran", "Duc", "Phuong"});
        example4(new String[]{"5", "2"});
    }

    public static void example1() {
        System.out.println("Hello world");
        System.out.println("Total: " + 5 + 7);
    }

    public static void example2(String[] args) {
        System.out.println("The number of argument is: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Value at " + i + " is: " + args[i]);
        }
    }

    public static void example3(String[] args) {
        Arrays.stream(args)
                .forEach((value) -> {
                    System.out.println("Values is: " + value);
                });
    }

    public static void example4(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        System.out.println("Subtraction example: " + (number1 - number2));
        System.out.println("Relational example: " + (number1 > number2));

    }
}
