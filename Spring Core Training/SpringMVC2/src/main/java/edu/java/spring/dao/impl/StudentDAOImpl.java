package edu.java.spring.dao.impl;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {

    private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, "student", null);

        if (resultSet.next()) {
            LOGGER.info("Table " + resultSet.getString("TABLE_NAME") + " already exist");
            return;
        }

        jdbcTemplate.execute("create table student (\n" +
                "\tid   bigint primary key auto_increment,\n" +
                "\tname varchar(1000), \n" +
                "\tage  integer\n" +
                ")");
    }

    @Override
    public void insert(Student student) {
        String insertQuery = "INSERT INTO student(name, age) VALUES(?, ?)";
        jdbcTemplate.update(insertQuery, student.getName(), student.getAge());
        LOGGER.info("Created record:  Name = " + student.getName() + " Age = " + student.getAge());
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
                e.printStackTrace();
                LOGGER.error(e.getMessage());
                return null;
            }
        }
    }

    @Override
    public List<Student> list() {
        String selectAllQuery = "SELECT * FROM student";
        return jdbcTemplate.query(selectAllQuery, new StudentRowMapper());
    }

    @Override
    public List<Student> listStudentByName(String name) {
        String selectStudentByNameQuery = "SELECT * FROM student WHERE name LIKE ?";
        return jdbcTemplate.query(selectStudentByNameQuery, new StudentRowMapper(), "%" + name + "%");
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = "DELETE FROM student WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);
    }

    @Override
    public Student get(Integer id) {
        String updateQuery = "SELECT * FROM student WHERE id = ?";
        return jdbcTemplate.queryForObject(updateQuery, new StudentRowMapper(), id);
    }

    @Override
    public void update(Student student) {
        String updateQuery = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(updateQuery, student.getName(), student.getAge(), student.getId());
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:mysql://localhost:3306/test;shutdown=true");
    }
}
