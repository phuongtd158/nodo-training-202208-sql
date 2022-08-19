package com.demo.unit6_java_thread;

public class SynchronizedStatementExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumber());
        thread1.setName("Hanoi_Thread 1");
        thread1.start();

        Thread thread2 = new Thread(new PrintNumber());
        thread2.setName("Hanoi_Thread 2");
        thread2.start();
    }

    static class PrintNumber implements Runnable {

        private Integer number = 1;

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            synchronized (number) {
                while (number < 30) {
                    number++;
                    System.out.println(currentThread.getName() + " number is " + number);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(currentThread.getName() + " is stopped");
        }
    }
}
