package com.demo.unit12_java_jdbc;


import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;

public class DataFilter implements Predicate {

    @Override
    public boolean evaluate(RowSet rs) {
        CachedRowSet cachedRowSet = (CachedRowSet) rs;
        try {
            return cachedRowSet.getString("name").contains("Tran");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }
}
