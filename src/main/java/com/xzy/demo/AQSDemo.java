package com.xzy.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiazhengyue
 * @since 2021-04-10
 */
public class AQSDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = () -> {
            lock.lock();
            System.out.println("locked");
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
