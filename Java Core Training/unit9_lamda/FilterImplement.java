package com.demo.unit9_lamda;

public class FilterImplement implements IFilter<Student> {

    @Override
    public boolean valid(Student student) {
        return student.getAge() >= 30 ? true : false;
    }
}
