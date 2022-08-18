package com.demo.unit7_java_io.part1;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFileNIOExample {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("C:\\Temp\\io_sample.txt");
        File desFile = new File(sourceFile.getParentFile(), "io_sample2.txt");
        FileChannel srcChannel = null;
        FileChannel desChannel = null;

        srcChannel = new FileInputStream(sourceFile).getChannel();
        desChannel = new FileOutputStream(desFile).getChannel();
        srcChannel.transferTo(0, srcChannel.size(), desChannel);

        Desktop.getDesktop().open(sourceFile.getParentFile());
    }
}
