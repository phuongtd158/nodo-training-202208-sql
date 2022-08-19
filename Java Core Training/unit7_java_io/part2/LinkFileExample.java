package com.demo.unit7_java_io.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LinkFileExample {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Temp\\hanoijava.txt");
        Path target = Paths.get("C:\\Temp\\test2\\hanoijava.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(
                source,
                Charset.defaultCharset(),
                StandardOpenOption.APPEND)) {
            writer.write("Java NIO 2 example \r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(target, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
