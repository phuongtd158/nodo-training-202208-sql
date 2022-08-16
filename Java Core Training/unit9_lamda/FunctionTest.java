package com.demo.unit9_lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest {
    public static void main(String[] args) {
        example3();
    }

    public static void example1() {
        List<Student> students = new ArrayList<>();
        Consumer<Student> consumer = (Student student) -> {
            if (student.getAge() > 23) {
                student.setAge(23);
            }
            students.add(student);
        };

        consumer.accept(new Student(24, "Tran Thi D"));
        System.out.println(students.get(0));
    }

    public static void example2() {
        String[] names = {
                "Tran Van A",
                "Tran Thi B",
                "Nguyen Van C"
        };
        Integer[] age = {18, 24, 45};

        IntStream integerStream = IntStream.rangeClosed(0, names.length - 1);
        integerStream
                .mapToObj(value -> new Student(age[value], names[value]))
                .forEach(System.out::println);
    }

    public static void example3() {
        Consumer<Student> consumer = System.out::println;

        String[] names = {
                "Tran Van A",
                "Tran Thi B",
                "Nguyen Van C"
        };
        Integer[] age = {18, 24, 45};

        IntStream integerStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = integerStream
                .mapToObj(value -> new Student(age[value], names[value]));

        Function<Student, String> jsonToFunction = (Student student) -> {
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid: ").append(student.getId()).append("\n");
            builder.append("\tname: ").append(student.getName()).append("\n");
            builder.append("\tage: ").append(student.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };
        consumer = (Student student) -> {
            System.out.println(jsonToFunction.apply(student));
        };

        //stream.forEach(consumer);

        Predicate<Student> predicate = (Student student) -> {
            return student.getAge() > 30;
        };
        Stream<Student> older = stream.filter(predicate);
        older.forEach(consumer);

        Supplier<Student> supplier = () -> {
            return new Student(20, "Tran Duc Phuong");
        };
        System.out.println(jsonToFunction.apply(supplier.get()));
    }

}
