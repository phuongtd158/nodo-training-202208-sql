package com.demo.unit7_java_io.part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyingAndMovingExample {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Temp\\hanoijava.txt");
        Path target = Paths.get("C:\\Temp\\test2\\hanoijava.txt");

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(target);
        Files.createLink(target, source);
    }
}
