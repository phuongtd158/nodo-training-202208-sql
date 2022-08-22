package com.demo.unit12_java_jdbc;


public class UpdateDataExample {

    public static final String SQL_UPDATE = "UPDATE PHUONGTD_TEST SET name = ?, age = ? WHERE id = ?";

    public static void main(String[] args) {
        int update = JDBCHelper.update(SQL_UPDATE, "Test Update", 18, 2);

        if (update == 1) {
            System.out.println("Update success!");
        } else {
            System.out.println("Update fail");
        }
    }
}
