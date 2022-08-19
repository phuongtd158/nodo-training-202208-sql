package com.demo.unit8_java_networking;

import jdk.net.Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {

    public static void main(String[] args) throws IOException {
        new SocketServerExample(9245);
    }

    public SocketServerExample(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("SERVER Listening...");

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try (DataInputStream input = new DataInputStream(socket.getInputStream());
                     DataOutputStream output = (DataOutputStream) socket.getOutputStream()) {

                    System.out.println("Client say: " + input.readUTF());
                    output.writeUTF("I'm a socket server");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
