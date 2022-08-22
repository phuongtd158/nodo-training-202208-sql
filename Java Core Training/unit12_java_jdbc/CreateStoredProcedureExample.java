package com.demo.unit12_java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        Statement statement = connection.createStatement();

        String procedure = "create procedure GET_AGES(STREAM_NAME VARCHAR2(255), OUT_AGE NUMBER(2) +)";

        statement.executeUpdate(procedure);

        connection.close();
    }
}
