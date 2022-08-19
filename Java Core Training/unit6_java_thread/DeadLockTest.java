package com.demo.unit6_java_thread;

public class DeadLockTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new DeadLockDemo(obj1, obj2);
        Thread thread2 = new DeadLockDemo(obj2, obj1);

        thread1.start();
        thread2.start();
    }
}
