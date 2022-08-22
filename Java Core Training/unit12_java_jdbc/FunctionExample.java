package com.demo.unit12_java_jdbc;

import java.sql.*;

public class FunctionExample {
    public static void getAge(String name, int[] ages) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        Statement statement = connection.createStatement();

        String sql = "select max(age) from PHUONGTD_TEST where name like '%" + name + "%'";

        ResultSet resultSet = statement.executeQuery(sql);
        ages[0] = resultSet.next() ? resultSet.getInt(1) : -1;

        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int[] ages = new int[1];
        getAge("Test", ages);
        System.out.println(ages[0]);
    }
}
