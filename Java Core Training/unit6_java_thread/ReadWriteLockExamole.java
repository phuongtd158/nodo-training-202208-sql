package com.demo.unit6_java_thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExamole {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String, String> map = new HashMap<>();

        executor.submit(() -> {
            System.out.println("Start writing 1");
            try {
                TimeUnit.SECONDS.sleep(10);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("End writing 1");
            }
        });

        Runnable readTask = () -> {
            System.out.println("Start reading 1");
            try {
                System.out.println(map.get("foo"));
            } finally {
                System.out.println("End reading 1");
            }
        };

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            System.out.println("Start writing 2");
            lock.writeLock().lock();
            try {
                map.put("foo1", "bar");
            } finally {
                lock.writeLock().unlock();
                System.out.println("End writing 2");
            }
        });

        Runnable readTask2 = () -> {
            System.out.println("Start reading 2");
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo1"));
            } finally {
                lock.readLock().unlock();
                System.out.println("End reading 2");
            }
        };
    }
}
