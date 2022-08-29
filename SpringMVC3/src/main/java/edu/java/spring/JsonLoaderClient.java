package edu.java.spring;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JsonLoaderClient {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/clazz/json");
        URLConnection urlConnection = url.openConnection();

        urlConnection.addRequestProperty("Accept", "Application/json");
        InputStream inputStream = urlConnection.getInputStream();

        int read;
        byte[] bytes = new byte[4 * 1024];
        while ((read = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, read));
        }
    }
}
