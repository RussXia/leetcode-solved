package com.xzy.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiazhengyue
 * @since 2021-04-16
 */
public class TtlAgentDemo {

    private static final TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("Hello123");
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 2; i++) {
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + "--------" + threadLocal.get());
                threadLocal.set("Hello-321");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--------" + threadLocal.get());
            };
//            System.out.println("is TtlRunnable ? " + (runnable instanceof TtlRunnable));
//            System.out.println("is Object ? " + (runnable instanceof Object));
//            System.out.println(runnable.getClass().getName());
            executorService.execute(runnable);
        }
        System.out.println(Thread.currentThread().getName() + "--------" + threadLocal.get());
        executorService.shutdown();
    }
}
