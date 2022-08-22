package com.demo.unit12_java_jdbc;

import java.sql.*;

public class TransactionExample {

    public static final String DB_URL = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
    public static final String USER_NAME = "SCOTT";
    public static final String PASSWORD = "SCOTT";
    public static final String SQL_INSERT = "INSERT INTO PHUONGTD_TEST(id, name, age) VALUES (PHUONGTD_TEST_SEQ.nextval, ?, ?)";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        PreparedStatement statement = null;

        connection.setAutoCommit(false);


        for (int i = 0; i < 10; i++) {

            String name = "Name test " + i;
            int age = 10 + i;

            statement = connection.prepareStatement(SQL_INSERT);
            statement.setString(1, name);
            statement.setInt(2, age);

            statement.executeUpdate();
        }

        connection.rollback();
        connection.setAutoCommit(true);

        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM PHUONGTD_TEST");
        if (resultSet.next()) {
            System.out.println("Total records: " + resultSet.getInt(1));
        }

        connection.close();
    }
}
