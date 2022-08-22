package com.demo.unit12_java_jdbc;

import java.sql.*;

public class JDBCMetaDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println("DB version: " + metaData.getDatabaseMajorVersion());
        System.out.println("Driver name: " + metaData.getDriverName());

        connection.close();
    }
}
