package com.demo.unit7_java_io.part1;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessExample {
    public static void main(String[] args) {
        File file = new File("C:\\Temp\\io_sample.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            randomAccessFile.seek(3);
            byte[] bytes = new byte[4 * 1024];
            int read = randomAccessFile.read(bytes);
            System.out.println(new String(bytes, 0, read, "UTF-8"));

            randomAccessFile.seek(file.length());
            randomAccessFile.write("\r\n".getBytes(StandardCharsets.UTF_8));
            randomAccessFile.writeChars("Hello Co Can");

            Desktop.getDesktop().open(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
