package com.demo.unit8_java_networking;

import java.io.*;
import java.net.Socket;

public class SocketClientExample {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9245);
        System.out.println("CLIENT start sending...");

        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            System.out.println("Server say " + input.read());
        } finally {
            socket.close();
        }
    }
}
