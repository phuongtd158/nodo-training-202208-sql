package com.demo.unit6_java_thread;

import java.util.concurrent.TimeUnit;

public class StopThreadExample {
    public static void main(String[] args) throws InterruptedException {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);

        thread.setName("Hanoi_Thread");
        thread.start();

        while (thread.isAlive()) {
            if (number.getNumber() % 10 == 0) {
                number.setAlive(false);
                Thread.sleep(1000);
            }
        }

        Thread.currentThread().join();

        while (thread.isAlive()) {
            if (number.getNumber() % 10 == 0) {
                number.setAlive(false);
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
