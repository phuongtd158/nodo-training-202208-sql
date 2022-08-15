package com.demo.main;

import com.demo.entity.Person;

public class ClassExample {
    public static void main(String[] args) {
        example1(new String[]{"Tran Duc Phuong", "Nguyen Viet Hien"});
    }

    public static void example1(String[] args) {
        Person person1 = new Person(args[0]);
        Person person2 = new Person(args[1]);

        System.out.println("Person 1's name is: " + person1.getName());
        System.out.println("Person 2's name is: " + person2.getName());
    }
}
