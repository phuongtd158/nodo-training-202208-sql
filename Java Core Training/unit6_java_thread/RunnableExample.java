package com.demo.unit6_java_thread;

public class RunnableExample {
    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("Say hello to everyone");
        new Thread(message).start();
        new Thread(message).start();
    }

}
