package com.demo.unit8_java_networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "<html><h2 style='color: red;'>This is the response</h2></html>";
        exchange.sendResponseHeaders(200, message.length());
        // OutputStream out = exchange.getResponseBody();

        try (OutputStream out = exchange.getResponseBody()) {
            out.write(message.getBytes());
        }
    }
}
