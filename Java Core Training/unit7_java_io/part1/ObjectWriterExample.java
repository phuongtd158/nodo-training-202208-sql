package com.demo.unit7_java_io.part1;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.stream;

public class ObjectWriterExample {
    public static void main(String[] args) throws IOException {

        File folder = new File("C:\\Temp\\test1\\");

        FileOutputStream fileOutputStream = new FileOutputStream(new File(folder, "my_object.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        PrintMessage printMessage = new PrintMessage("Con Noi Noi");
        objectOutputStream.writeObject(printMessage);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static class PrintMessage implements Runnable, Serializable {

        private String message;

        public PrintMessage(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            String[] elements = message.split(" ");
            stream(elements).forEach(ele -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " print " + ele);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
