package com.demo.unit12_java_jdbc;

import java.sql.*;

public class JDBCHelper {

    public static final String DB_URL = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
    public static final String USER_NAME = "SCOTT";
    public static final String PASSWORD = "SCOTT";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static PreparedStatement getStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }

        return preparedStatement;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement statement = getStatement(sql, args);
        return statement.executeQuery();
    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement preparedStatement = getStatement(sql, args);
            try {
                return preparedStatement.executeUpdate();
            } finally {
                preparedStatement.getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
