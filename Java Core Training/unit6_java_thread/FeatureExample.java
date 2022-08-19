package com.demo.unit6_java_thread;

import java.util.concurrent.*;

public class FeatureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CallableSample callable = new CallableSample();

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(callable);

        System.out.println("Future Done ? " + future.isDone());

        int result = future.get(3, TimeUnit.SECONDS);

        System.out.println("Future Done ? " + future.isDone() + " - Result = " + result);
    }

}
