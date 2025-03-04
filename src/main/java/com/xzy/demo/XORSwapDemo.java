package com.xzy.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * User: RuzzZZ
 * Date: 2024/4/16
 * Time: 14:49
 */
public class XORSwapDemo {

    public static void main(String[] args) {
        // 创建一个具有核心线程数为2的 ScheduledThreadPoolExecutor
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

        // 创建一个任务，打印当前时间
        Runnable task = () -> System.out.println("当前时间: " + System.currentTimeMillis());

        // 安排任务在初始延迟1秒后开始，每隔3秒执行一次
        scheduledExecutor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);

        // 为了演示，运行10秒后关闭调度器
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledExecutor.shutdown();
    }
}
