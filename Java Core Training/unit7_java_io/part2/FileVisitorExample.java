package com.demo.unit7_java_io.part2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileVisitorExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Temp");
        Files.walkFileTree(path, new PrintFiles());
    }

    public static class PrintFiles extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path path) {
            System.out.println(path + " is file");
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult postVisitDirectory() {
            System.out.println("is directory");
            return FileVisitResult.CONTINUE;
        }
    }
}
