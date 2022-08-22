package com.demo.unit12_java_jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class DataAccessTest {
    public static void main(String[] args) throws SQLException {
        DataAccessLogic data = new DataAccessLogic();
        AtomicReference<List<String>> names = new AtomicReference<>(data.loadNames(1));

        names.get().forEach(System.out::println);
        System.out.println("Total page = " + data.numberOfPage());

        IntStream.range(1, data.numberOfPage() + 1).forEach(page -> {
            System.out.println("================== " + page);
            try {
                names.set(data.loadNames(page));
                System.out.println(names);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
