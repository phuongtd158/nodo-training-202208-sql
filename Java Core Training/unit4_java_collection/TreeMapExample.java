package com.demo.unit4_java_collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        map.put(2, "Nguyen Van C");
        map.put(4, "Nguyen Van B");
        map.put(3, "Nguyen Van D");
        map.put(1, "Nguyen Van A");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
        }
    }
}
