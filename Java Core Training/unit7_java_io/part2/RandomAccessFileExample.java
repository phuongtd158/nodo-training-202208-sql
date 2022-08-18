package com.demo.unit7_java_io.part2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Temp\\hanoijava2.txt");
        ByteBuffer buffer = ByteBuffer.allocate(15);

        try (FileChannel fileChannel = FileChannel.open(path)) {
            fileChannel.read(buffer);
            System.out.println(new String(buffer.array()));

            fileChannel.position(0);
            byte[] bytes = "Tran".getBytes();
            fileChannel.write(ByteBuffer.wrap(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
