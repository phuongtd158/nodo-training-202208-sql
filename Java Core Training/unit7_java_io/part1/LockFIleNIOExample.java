package com.demo.unit7_java_io.part1;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFIleNIOExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Temp\\io_sample.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        FileChannel fileChannel = randomAccessFile.getChannel();
        FileLock fileLock = fileChannel.tryLock(0, Long.max(10, 20), false);

        Desktop.getDesktop().edit(file);
        Thread.sleep(10 * 1000l);
        fileLock.release();
    }
}
