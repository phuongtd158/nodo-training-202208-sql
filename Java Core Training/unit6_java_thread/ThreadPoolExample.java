package com.demo.unit6_java_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0, 6).forEach(i -> executorService.submit(new PrintNumber()));

    }

    static class PrintNumber implements Runnable {

        private Integer number = 1;

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            while (true) {
                number++;
                System.out.println(currentThread.getName() + " number is " + number);
                try {
                    Thread.sleep(300);
                    if (number % 10 == 0) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(currentThread.getName() + " is stopped");
        }
    }
}
