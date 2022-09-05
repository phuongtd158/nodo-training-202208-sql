package edu.hanoi.service.springhnservice.test;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class RestClientTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/user/list");
        URLConnection connection = url.openConnection();


        connection.setRequestProperty("Accept", "application/json");
        String account = "admin:123";
        String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(account.getBytes());
        connection.setRequestProperty("Authorization", basicAuth);
        InputStream inputStream = connection.getInputStream();

        byte[] bytes = new byte[4 * 1024];
        int read = -1;

        try {
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
        } finally {
            inputStream.close();
        }

    }
}
