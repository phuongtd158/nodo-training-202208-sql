package com.demo.unit8_java_networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream stream = connection.getInputStream();

        int read;
        byte[] bytes = new byte[0];
        while ((read = stream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, read));
        }
    }
}
