package com.demo.unit2_javabasic2.main;

public class SystemExample {

    public static void main(String[] args) {
        System.out.println("JAVA_HOME: " + System.getProperty("java.home"));
//        System.setProperty("java.home", "C");
        System.out.println("User: " + System.getProperty("user.name"));
    }
}
