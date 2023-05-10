package com.xzy.reactor;

import java.util.concurrent.*;

/**
 * User: RuzzZZ
 * Date: 2023/3/22
 * Time: 19:27
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is running stage 1!");
        }, Executors.newFixedThreadPool(5, r -> new Thread(r, "fixedThread")));
        future.thenCompose(item->{
            System.out.println(Thread.currentThread().getName() + " is running stage 2!");
            return CompletableFuture.completedFuture(Void.class);
        });
        Thread.currentThread().join(10000);
    }

}
