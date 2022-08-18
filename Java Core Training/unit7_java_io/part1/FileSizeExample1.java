package com.demo.unit7_java_io.part1;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample1 {
    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size: " + getSize(file) / (1024 * 1024) + " MB");
    }

    private static long getSize1(File file) {
        if (file.isFile()) {
            return file.length();
        }

        File[] files = file.listFiles();
        int length = 0;

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()) {
                length += getSize1(files[i]);
                continue;
            }
            length += files[i].length();
        }
        return length;
    }

    public static long getSize(File file) {
        if (file.isFile()) {
            return file.length();
        }

        AtomicLong length = new AtomicLong(0);
        Arrays.stream(file.listFiles())
                .forEach(f -> {
                    length.getAndSet(
                            length.longValue() + (f.isFile() ? f.length() : getSize(f))
                    );
                });

        return length.longValue();
    }
}
