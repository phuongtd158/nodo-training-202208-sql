package com.demo.unit12_java_jdbc;

import java.sql.*;

public class BatchProcessingExample {

    public static final String SQL_INSERT = "INSERT INTO PHUONGTD_TEST(id, name, age) VALUES (PHUONGTD_TEST_SEQ.nextval, ?, ?)";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT);


        for (int i = 0; i < 20; i++) {
            String name = "Name test " + i;
            int age = 10 + i;

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.addBatch();
        }

        statement.executeBatch();

        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM PHUONGTD_TEST");
        if (resultSet.next()) {
            System.out.println("Total records: " + resultSet.getInt(1));
        }

        connection.close();
    }
}
