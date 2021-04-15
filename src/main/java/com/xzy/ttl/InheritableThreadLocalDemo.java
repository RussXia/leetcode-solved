package com.xzy.ttl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class InheritableThreadLocalDemo {

    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        inheritableThreadLocal.set("hello123");
        executorService.execute(() -> {
            System.out.println(inheritableThreadLocal.get());
            inheritableThreadLocal.set("sub-hello123");
        });

        TimeUnit.SECONDS.sleep(1);

        // 设置新的值
        inheritableThreadLocal.set("hello321");

        executorService.execute(() -> System.out.println(inheritableThreadLocal.get()));


        executorService.shutdown();
    }
}
