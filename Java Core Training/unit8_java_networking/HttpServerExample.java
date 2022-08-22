package com.demo.unit8_java_networking;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpServerExample {
    public static void main(String[] args) throws IOException {
        TestHandler testHandler = new TestHandler();
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/test", testHandler);
        server.setExecutor(Executors.newFixedThreadPool(5));

        server.start();
    }
}
