package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {

    private static final Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    private String insertQuery;
    private String updateAgeByNameSQL;
    private String deleteStudentByNameSQL;

    public StudentJdbcDAO() {
        transactionManager = new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
                return null;
            }

            @Override
            public void commit(TransactionStatus transactionStatus) throws TransactionException {

            }

            @Override
            public void rollback(TransactionStatus transactionStatus) throws TransactionException {

            }
        };
    }

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null, null, "student", null);

        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }

        jdbcTemplate.execute("create table student (\n" +
                "\tid   bigint primary key auto_increment,\n" +
                "\tname varchar(1000), \n" +
                "\tage  integer\n" +
                ")");

    }

    public void insert(String name, int age) {
        jdbcTemplate.update(insertQuery, name, age);
        LOGGER.info("Created record:  Name = " + name + " Age = " + age);
    }

    public void save(String name, Integer age) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        int total = 0;
        String countQuery = "SELECT count(*) FROM student";

        try {
            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("Before save data. Total record is: " + total);

            insert(name, age);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("After save data. Total record is: " + total);

            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

            transactionManager.rollback(transactionStatus);

            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("After rollback. Total record is: " + total);

            throw new RuntimeException(e);
        }
    }

    public int[] addBatch(List<Student> students) {
        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> {
            batch.add(new Object[]{
                    student.getName(), student.getAge()
            });
        });
        return jdbcTemplate.batchUpdate(insertQuery, batch);
    }

    public void updateAgeByName(String name, Integer age) {
        jdbcTemplate.update(updateAgeByNameSQL, age, name);
        LOGGER.info("Update record:  Name = " + name + " Age = " + age);
    }

    public void deleteStudentByName(String name) {
        jdbcTemplate.update(deleteStudentByNameSQL, name);
        LOGGER.info("Deleted student " + name + " success");
    }

    public int totalRecords() {
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM student");
                return resultSet.next() ? resultSet.getInt(1) : 0;
            }
        });
    }

    public int totalRecords2() {
        return jdbcTemplate.execute((Statement statement) -> {
            ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM student");
            return resultSet.next() ? resultSet.getInt(1) : 0;
        });
    }

    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));

                return student;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return null;
            }
        }
    }

    public List<Student> loadStudentByName(String name) {
        return jdbcTemplate.query("SELECT * FROM student WHERE name LIKE '%" + name + "%'", new StudentRowMapper());
    }

    public List<Student> loadAllStudent() {
        return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
        this.updateAgeByNameSQL = updateAgeByNameSQL;
    }

    public void setDeleteStudentByNameSQL(String deleteStudentByNameSQL) {
        this.deleteStudentByNameSQL = deleteStudentByNameSQL;
    }
}
