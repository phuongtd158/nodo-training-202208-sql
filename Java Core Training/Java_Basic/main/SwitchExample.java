package com.demo.main;

public class SwitchExample {
    public static void main(String[] args) {
        example1(new String[]{"5"});
    }

    public static void example1(String[] args) {
        int value = Integer.parseInt(args[0]);

        switch (value) {
            case 0 -> System.out.println("Bad");
            case 1 -> System.out.println("Ok");
            default -> System.out.println("Invalid");
        }
    }
}
