package com.demo.unit6_java_thread;

public class PrintNumber implements Runnable {

    private int number = 1;
    private boolean alive = true;

    public int getNumber() {
        return number;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (alive) {
            try {
                number++;
                System.out.println(currentThread.getName() + " number is \"" + number + "\"");
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(currentThread.getName() + " is stopped");
    }
}
