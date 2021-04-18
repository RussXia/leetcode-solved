package com.xzy.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiazhengyue
 * @since 2021-04-16
 */
public class TtlRunnableDemo {

    private static final TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        transmittableThreadLocal.set("Hello");


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            transmittableThreadLocal.set("Hello-" + i);
            Runnable runnable = TtlRunnable.get(() -> {
                System.out.println(transmittableThreadLocal.get());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(transmittableThreadLocal.get());
            });
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
