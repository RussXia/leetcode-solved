package com.xzy.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierLatchComparison {
    public static void main(String[] args) {
        // 演示 CyclicBarrier
        demonstrateCyclicBarrier();

        System.out.println("\n-------------------\n");

        // 演示 CountDownLatch
        demonstrateCountDownLatch();
    }

    private static void demonstrateCyclicBarrier() {
        System.out.println("CyclicBarrier Demo:");

        // 创建一个包含3个线程的栅栏，所有线程到达后执行回调
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
                System.out.println("All tasks complete, barrier is released!")
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 模拟两轮游戏，每轮需要3个玩家都准备好才能开始
        for (int round = 1; round <= 2; round++) {
            final int currentRound = round;
            for (int i = 1; i <= 3; i++) {
                final int playerId = i;
                executor.submit(() -> {
                    try {
                        // 模拟玩家准备
                        System.out.printf("Round %d: Player %d is getting ready\n",
                                currentRound, playerId);
                        Thread.sleep((long) (Math.random() * 1000));

                        System.out.printf("Round %d: Player %d is ready\n",
                                currentRound, playerId);
                        barrier.await(); // 等待其他玩家

                        // 所有玩家都准备好后继续
                        System.out.printf("Round %d: Player %d starts playing\n",
                                currentRound, playerId);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        shutdownAndAwaitTermination(executor);
    }

    private static void demonstrateCountDownLatch() {
        System.out.println("CountDownLatch Demo:");

        // 创建一个计数器为3的CountDownLatch
        CountDownLatch startSignal = new CountDownLatch(1); // 用于控制开始
        CountDownLatch doneSignal = new CountDownLatch(3); // 用于等待完成

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 启动3个工作线程
        for (int i = 1; i <= 3; i++) {
            final int workerId = i;
            executor.submit(() -> {
                try {
                    System.out.printf("Worker %d is ready\n", workerId);
                    startSignal.await(); // 等待开始信号

                    // 模拟工作
                    System.out.printf("Worker %d is working\n", workerId);
                    Thread.sleep((long) (Math.random() * 1000));

                    System.out.printf("Worker %d finished\n", workerId);
                    doneSignal.countDown(); // 完成工作，计数减1
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            System.out.println("Main thread is preparing...");
            Thread.sleep(1000);

            // 发出开始信号
            System.out.println("Main thread signals workers to start");
            startSignal.countDown();

            // 等待所有工作完成
            doneSignal.await();
            System.out.println("All workers have finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shutdownAndAwaitTermination(executor);
    }

    private static void shutdownAndAwaitTermination(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
