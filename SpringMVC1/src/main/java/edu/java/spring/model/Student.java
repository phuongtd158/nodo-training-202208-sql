package edu.java.spring.model;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 100, message = "Phai nhap tu 2 toi 100 ky tu")
    private String name;

    @Range(min = 1, max = 150, message = "Phai nhap tu 1 toi 150")
    private Integer age;

    public Student() {

    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
