package com.demo.main;

public class IfElseExample {
    public static void main(String[] args) {
        example1(new String[]{"10"});
    }

    public static void example1(String[] args) {
        int value = Integer.parseInt(args[0]);

        if (value < 5) {
            System.out.println("Bad");
        } else {
            System.out.println("Ok");
        }
        ;
    }
}
