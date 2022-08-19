package com.demo.unit6_java_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<Object> value = Executors.callable(new PrintNumber());
        System.out.println("Main say hello");
        value.call();
        System.out.println("Main say goodbye");
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
