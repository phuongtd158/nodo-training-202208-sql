package com.demo.unit6_java_thread;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable, Serializable {

    private String message;

    public PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public synchronized void run() {
        String[] elements = message.split(" ");
        Arrays.stream(elements)
                .forEach(element -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + " print " + element);
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        try {
            Thread.sleep((int) (Math.random() * 3) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
