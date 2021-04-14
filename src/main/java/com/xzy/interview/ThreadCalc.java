package com.xzy.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class ThreadCalc {

    public static void main(String[] args) {
        List<Future<Integer>> result = new ArrayList<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int start = (finalI - 1) * 10 + 1;
                    int sum = 0;
                    for (int j = start; j < (start + 10); j++) {
                        sum += j;
                    }
                    return sum;
                }
            };
            Future<Integer> future = executorService.submit(callable);
            result.add(future);
        }

        int totalSum = result.stream()
                .map(record -> {
                    try {
                        return record.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException("calc failed");
                    }
                }).mapToInt(Integer::intValue)
                .sum();
        System.out.println(totalSum);
        executorService.shutdown();
    }
}
