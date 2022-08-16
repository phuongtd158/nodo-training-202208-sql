package com.demo.unit2_javabasic2.main;

public class TryCatchExample {
    public static void main(String[] args) {

        System.out.println("Number: " + toNumber("123"));

        System.out.println("Number: " + toNumber("abc"));

    }

    public static int toNumber(String value) {

        try {
            Integer integerValue = Integer.parseInt(value);
            return integerValue;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
