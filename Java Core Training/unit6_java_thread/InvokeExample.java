package com.demo.unit6_java_thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokeExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables = Arrays.asList(
                new CallableSample(),
                new CallableSample(),
                new CallableSample()
        );

        Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
        Stream<Integer> resultStream = stream.map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        });

        Integer[] results = resultStream.toArray(Integer[]::new);
        Arrays.stream(results).forEach(System.out::println);

        System.out.println("-------------> " + executor.invokeAny(callables));
    }
}
