package edu.java.spring.dao;

import edu.java.spring.model.Student;

import java.util.List;

public interface StudentDAO {
    void insert(Student student);

    List<Student> list();

    List<Student> listStudentByName(String name);

    void delete(Integer id);

    Student get(Integer id);

    void update(Student student);

}
