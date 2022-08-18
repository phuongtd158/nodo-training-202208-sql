package com.demo.unit7_java_io.part2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritePathExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp\\hanoijava2.txt");

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write("Tran Duc Phuong " + i + "\r\n");
            }
        }
    }
}
