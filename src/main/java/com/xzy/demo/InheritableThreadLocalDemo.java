package com.xzy.demo;

/**
 * @author xiazhengyue
 * @since 2021-04-14
 */
public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello123");
        inheritableThreadLocal.set("hello223");
        new Thread(() -> {
            System.out.println("sub-" + threadLocal.get());
            System.out.println("sub-" + inheritableThreadLocal.get());

            new Thread(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub-sub-" + threadLocal.get());
                System.out.println("sub-sub-" + inheritableThreadLocal.get());
            }).start();
            threadLocal.remove();
            inheritableThreadLocal.remove();
            System.out.println("sub removed");
        }).start();
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main-" + threadLocal.get());
        System.out.println("main-" + inheritableThreadLocal.get());
    }
}
