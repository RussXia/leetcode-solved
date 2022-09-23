package com.xzy.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiazhengyue
 * @since 2021-04-10
 */
@Slf4j
public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            lock.lock();
            log.info("locked");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(runnable);
        }
    }
}
