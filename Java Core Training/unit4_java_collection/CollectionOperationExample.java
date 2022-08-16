package com.demo.unit4_java_collection;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperationExample {
    public static void main(String[] args) {
        example3();
    }

    public static void example1() {
        List<Integer> listOfInteger = new ArrayList<>(Arrays.asList(1, 4, 2, 3, 6, 9, 7));

        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(listOfInteger, comparator);

        listOfInteger.stream()
                .filter(v -> v > 5)
                .forEach(System.out::println);

        Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
    }

    public static void example2() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Consumer<Integer> myConsumer = n -> {
            System.out.println("User input value: " + n);
            if (n < 5) {
                System.out.println("Invalid value");
                return;
            }
            list.add(n);
            list.forEach(v -> {
                System.out.print(v + ", ");
            });
        };

        while (true) {
            System.out.println("Please input a number: ");
            int value = scanner.nextInt();

            if (value < 0) {
                break;
            }

            myConsumer.accept(value);
            System.out.println();
        }
    }

    public static void example3() {
        List<Integer> listIntegers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Predicate<Integer> tester = v -> v > 5;
        Consumer<Integer> myConsumer = n -> listIntegers.add(n);

        while (true) {
            System.out.println("Please input a number: ");
            int value = scanner.nextInt();
            if (value < 0) {
                break;
            }
            if (tester.test(value)) {
                myConsumer.accept(value);
            }
        }
        listIntegers.forEach(x -> {
            System.out.print(x + ", ");
        });
    }
}
