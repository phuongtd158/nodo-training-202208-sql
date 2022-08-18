package com.demo.unit7_java_io.part1;

import java.io.File;
import java.nio.file.Files;

public class FileExample {
    public static void main(String[] args) {
        example1("C:\\Temp");
    }

    public static void example1(String url) {
        File file = new File(url);
        if (!file.isFile()) {
            System.out.println("This is folder");
        } else {
            System.out.println("This is file");
        }

        System.out.println(file.isFile() ? "This is file" : "This is folder");

        File[] files = file.listFiles();

        for (File f : files) {
            System.out.println("File name is: " + f.getName() + "\nFile length is: " + f.length() + " bytes");
        }

    }
}
