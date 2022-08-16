package com.demo.unit9_lamda;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " say hello Java class!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " say hello Java class!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable2).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " say hello Java class!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " say hello Java class!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
