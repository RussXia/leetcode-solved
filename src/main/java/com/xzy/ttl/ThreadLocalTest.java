package com.xzy.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class ThreadLocalTest {


    private static final AtomicInteger ID_SEQ = new AtomicInteger();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(1, r -> new Thread(r, "TTL-TEST-" + ID_SEQ.getAndIncrement()));

    //
//    private static ThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();

    //⑴ 声明TransmittableThreadLocal类型的ThreadLocal
    private static ThreadLocal<String> THREAD_LOCAL = new TransmittableThreadLocal<>();
    public static void testThreadLocal() throws InterruptedException {
        try {
            //doSomething()...
            THREAD_LOCAL.set("set-task-init-value");
            //
            Runnable task1 = () -> {
                try {
                    String manTaskCtx = THREAD_LOCAL.get();
                    System.out.println("task1:" + Thread.currentThread() + ", get ctx:" + manTaskCtx);
                    THREAD_LOCAL.set("task1-set-value");
                } finally {
                    THREAD_LOCAL.remove();
                }
            };
            EXECUTOR.submit(task1);

            //doSomething....
            TimeUnit.SECONDS.sleep(3);

            //⑵ 设置期望task2可获取的上下文
            THREAD_LOCAL.set("main-task-value");

            //⑶ task2的异步任务逻辑中期望获取⑵中的上下文
            Runnable task2 = () -> {
                String manTaskCtx = THREAD_LOCAL.get();
                System.out.println("task2:" + Thread.currentThread() + ", get ctx :" + manTaskCtx);
            };
            //⑷ 转换为TransmittableThreadLocal 增强的Runnable
            task2 = TtlRunnable.get(task2);
            EXECUTOR.submit(task2);
        }finally {
            THREAD_LOCAL.remove();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        testThreadLocal();
        EXECUTOR.shutdown();
    }
}
