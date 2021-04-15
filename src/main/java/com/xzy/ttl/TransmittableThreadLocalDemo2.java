package com.xzy.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class TransmittableThreadLocalDemo2 {

    private static final TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();


    public static void main(String[] args) throws InterruptedException {
        transmittableThreadLocal.set("Hello123");

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "-" + transmittableThreadLocal.get());
        });

        TimeUnit.SECONDS.sleep(1);

        transmittableThreadLocal.set("Hello321");

        //没用TtlExecutors进行分装，submit任务前，不会重新复制上下文到目标线程!
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "-" + transmittableThreadLocal.get());
        });

        executorService.shutdown();
    }
}
