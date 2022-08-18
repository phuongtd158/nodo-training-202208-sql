package com.demo.unit7_java_io.part2;

import java.io.IOException;
import java.nio.file.*;

public class FileFinderExample {
    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        Files.walkFileTree(Path.of("C:\\Temp"), finder);
    }

    public static class Finder extends SimpleFileVisitor {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile(Path path) {
            if (matcher.matches(path.getFileName())) {
                System.out.println("Found:" + path);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
