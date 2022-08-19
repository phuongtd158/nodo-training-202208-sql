package com.demo.unit6_java_thread;

public class DeadLockDemo extends Thread {

    private Object lock1;
    private Object lock2;

    public DeadLockDemo(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + ": Holding " + lock1 + "...");
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + ": ---> " + lock1 + ":" + lock2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + ": ---> " + lock1 + ":" + lock2);
        }
    }
}
