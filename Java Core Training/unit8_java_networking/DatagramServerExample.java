package com.demo.unit8_java_networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable {

    DatagramSocket socket;

    public DatagramServerExample() throws SocketException {
        socket = new DatagramSocket(4445);
        System.out.println("DATA SERVER listening...");
    }

    @Override
    public void run() {
        byte[] bytes = new byte[0];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        try {
            socket.receive(packet);

            bytes = "Server say hello Tran Duc Phuong".getBytes();
            socket.send(new DatagramPacket(
                    bytes,
                    bytes.length,
                    packet.getAddress(),
                    packet.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();
    }
}
