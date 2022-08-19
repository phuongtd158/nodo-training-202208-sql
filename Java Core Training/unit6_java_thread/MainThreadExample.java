package com.demo.unit6_java_thread;

public class MainThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new PrintNumber());
        thread.setName("Hanoi_Thread");
        thread.setDaemon(true);

        thread.start();

        Thread.currentThread().join();
        System.out.println("Main thread say hello");
        System.out.println("Main thread say goodbye");
    }

    static class PrintNumber implements Runnable {

        private int number = 1;

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            while (number < 10) {
                number++;
                System.out.println(currentThread.getName() + " number is " + number);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(currentThread.getName() + " is stopped");
        }
    }
}
