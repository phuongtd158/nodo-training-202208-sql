package com.demo.unit7_java_io.part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Temp\\io_sample.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        long size = fileChannel.size();
        ByteBuffer buffer = ByteBuffer.allocate((int) size);
        fileChannel.read(buffer);
        buffer.rewind();

        System.out.println(new String(buffer.array(), "UTF-8"));

        fileChannel.close();
        fileInputStream.close();
    }
}
