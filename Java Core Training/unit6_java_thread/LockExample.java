package com.demo.unit6_java_thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(4);
        CallableSample sample = new CallableSample();
        List<CallableSample> callables = Arrays.asList(sample, sample, sample, sample);

        executor.invokeAll(callables);
    }
}
