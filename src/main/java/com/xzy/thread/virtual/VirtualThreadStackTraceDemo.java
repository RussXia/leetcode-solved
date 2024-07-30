package com.xzy.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * User: RuzzZZ
 * Date: 2024/2/6
 * Time: 16:54
 */
@Slf4j
public class VirtualThreadStackTraceDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.ofVirtual().name("vt-1").start(()->{
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            log.info("{}", allStackTraces);
        });
        Thread.ofPlatform().name("pt-1").start(()->{
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            log.info("{}", allStackTraces);
        });
        Thread.currentThread().join(1000);
    }
}
