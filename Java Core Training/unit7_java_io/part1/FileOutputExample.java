package com.demo.unit7_java_io.part1;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        example3();
    }

    public static void example1() {
        File file = new File(
                "C:" + File.separator + "Temp" +
                        File.separator + "hanoijava.txt");
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = "Hello Hà Nội Java".getBytes(StandardCharsets.UTF_8);

            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void example2() throws IOException {
        File file = new File(
                "C:" + File.separator + "Temp" +
                        File.separator + "hanoijava.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[124];
            fileInputStream.read(bytes);

            System.out.println(new String(bytes));
        }
    }

    public static void example3() {
        File file = new File(
                "C:" + File.separator + "Temp" +
                        File.separator + "hanoijava.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[4 * 1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();

            while ((read = fileInputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, read));
            }

            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
