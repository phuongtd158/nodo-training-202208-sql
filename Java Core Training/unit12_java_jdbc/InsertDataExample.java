package com.demo.unit12_java_jdbc;

public class InsertDataExample {

    public static void main(String[] args) {
        String sql = "INSERT INTO PHUONGTD_TEST(id, name, age)\n" +
                "VALUES (PHUONGTD_TEST_SEQ.nextval, ?, ?)";
        JDBCHelper.update(sql, "Tran Duc Phuong", 20);
    }
}
