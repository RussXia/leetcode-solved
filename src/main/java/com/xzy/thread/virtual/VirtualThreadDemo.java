package com.xzy.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * User: RuzzZZ
 * Date: 2024/2/5
 * Time: 15:23
 */
@Slf4j
public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        var virtualFactory = Thread.ofVirtual().factory();
        virtualFactory.newThread(() -> System.out.println("虚拟线程执行中...")).start();

        var executor = Executors.newVirtualThreadPerTaskExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    log.info("虚拟线程替换线程池执行中..." + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        //executor.shutdownNow();
        executor.shutdown();
        Thread.currentThread().join(10 * 1000);
    }
}
