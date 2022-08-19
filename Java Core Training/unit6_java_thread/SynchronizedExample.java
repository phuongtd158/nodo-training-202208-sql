package com.demo.unit6_java_thread;

public class SynchronizedExample {
    public static void main(String[] args) {
        new Thread(new PrintMessage("Say hello to everyone")).start();
        new Thread(new PrintMessage("Say hello to everyone")).start();
    }
}
