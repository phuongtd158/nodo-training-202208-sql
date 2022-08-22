package com.demo.unit8_java_networking;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://phuongtd158.github.io/e-learning/#/home");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Path path = Paths.get("C:\\Temp\\test.html");

        try (InputStream inputStream = connection.getInputStream()) {
            OutputStream outputStream = Files.newOutputStream(
                    path,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            int read = -1;
            byte[] bytes = new byte[1];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } finally {
            Desktop.getDesktop().open(path.toFile());
        }
    }
}
