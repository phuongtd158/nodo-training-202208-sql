package com.demo.unit9_lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {

    public static List<Student> filter(List<Student> students) {
        List<Student> list = new ArrayList<>();
        IFilter<Student> filter = new FilterImplement();

        for (Student student : students) {
            if (filter.valid(student)) {
                list.add(student);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student( 38, "Nguyen Van A"));
        students.add(new Student( 39, "Nguyen Van B"));
        students.add(new Student(20, "Nguyen Thi C"));

        example3(students);
    }

    public static void example1(List<Student> students) {
        List<Student> filtered = filter(students);

        for (Student student : filtered) {
            System.out.println(student.toString());
        }
    }

    public static void example2(List<Student> students) {
//        Stream<Student> stream = students.stream()
//                .filter(student -> student.getAge() >= 30);
//
//        stream.forEach(System.out::println);
//
//        Collections.sort(students, (Student s1, Student s2) -> s1.getAge() - s2.getAge());
//        students.forEach(System.out::println);

        students.stream()
                .sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .forEach(System.out::println);
    }

    public static void example3(List<Student> students) {
        Comparator<Student> comparator = (s1, s2) -> s1.getAge() - s2.getAge();
        students.stream()
                .sorted(comparator)
                .forEach(System.out::println);

        System.out.println("Max: " + students.stream().max(comparator).get());

        int sum = students.stream()
                .mapToInt(Student::getAge)
                .sum();
        System.out.println("Average of age is: " + sum / students.size());

        students.parallelStream()
                .forEach((it) -> {
                    System.out.println(Thread.currentThread().getName() + " hello " + it.getName());
                });
    }
}
