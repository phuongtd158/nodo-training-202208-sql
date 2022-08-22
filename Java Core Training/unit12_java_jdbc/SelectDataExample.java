package com.demo.unit12_java_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDataExample {

    public static final String SQL_SELECT_ALL = "SELECT * FROM PHUONGTD_TEST";

    public static void main(String[] args) throws SQLException {

        ResultSet resultSet = JDBCHelper.query(SQL_SELECT_ALL);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);

            System.out.println(
                    "Id: "+ id
                    +"  Name: "+name
                    +"  Age: "+age
            );
        }
    }
}
