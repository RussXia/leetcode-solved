package com.xzy.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class TransmittableThreadLocalDemo {

    private static final TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        transmittableThreadLocal.set("Hello123");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(executorService);

        ttlExecutorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "-" + transmittableThreadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);

        transmittableThreadLocal.set("Hello321");

        ttlExecutorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "-" + transmittableThreadLocal.get());
        });

        ttlExecutorService.shutdown();

    }
}
