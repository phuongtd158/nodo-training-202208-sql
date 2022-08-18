package com.demo.unit7_java_io.part1;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        example2();
    }

    public static void example1() {
        File file = new File("C:\\Temp\\io_sample.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("\r\n");
            writer.write("Tran Duc Phuong");

            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void example2() throws IOException {
        File file = new File("C:\\Temp\\io_sample.txt");
        FileReader reader = new FileReader(file);

        char[] buffer = new char[4 * 1024];
        int read = -1;
        StringBuilder builder = new StringBuilder();

        while ((read = reader.read(buffer)) != -1) {
            builder.append(buffer, 0, read);
        }

        System.out.println(buffer);
        reader.close();
    }
}
