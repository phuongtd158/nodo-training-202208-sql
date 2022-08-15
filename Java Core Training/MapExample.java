package com.demo.main;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();

        map.put(2, "Nguyen Van C");
        map.put(4, "Nguyen Van B");
        map.put(3, "Nguyen Van D");
        map.put(1, "Nguyen Van A");

        System.out.println(map.get(3));

        map.put(3, "Nguyen Thi D");
        System.out.println(map.get(3));

        map.forEach((key, value) -> {
            System.out.println("Key: " + key + " - Value: " + value);
        });
    }
}
