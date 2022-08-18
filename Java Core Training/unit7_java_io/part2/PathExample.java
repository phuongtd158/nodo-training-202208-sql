package com.demo.unit7_java_io.part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        System.out.println("This is " + (!Files.isDirectory(path) ? "file" : "folder"));
        System.out.println(Files.exists(path));

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
        }

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path, filter)) {
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
        }

        Files.newDirectoryStream(path, "*{java, txt}");

        Path path1 = Paths.get("C:\\Temp");
        Path path2 = path1.resolve("hanoijava.txt");
        try (BufferedReader reader = Files.newBufferedReader(path2, StandardCharsets.UTF_8)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
