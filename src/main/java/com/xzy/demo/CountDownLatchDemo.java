package com.xzy.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CountDownLatchDemo {
    // 请求的数量
    private static final int THREAD_COUNT = 101;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
        // 只是测试使用，实际场景请手动赋值线程池参数
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("active count : " + threadPool.getActiveCount());
        System.out.println("task count : " +threadPool.getTaskCount());
        System.out.println("completed task count : " +threadPool.getCompletedTaskCount());
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println(Thread.currentThread().getName() + " - finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " - threadNum:" + threadnum);
        Thread.sleep(1000);
    }
}


