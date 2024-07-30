package com.xzy.thread.virtual;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * User: RuzzZZ
 * Date: 2024/2/6
 * Time: 16:03
 */
@Slf4j
public class ReentrantLockVirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread.startVirtualThread(lock::lock);
        // 确保锁已经被上面的虚拟线程持有
        Thread.sleep(1000);
        Thread.startVirtualThread(() -> {
            log.info("first");
            lock.lock();
            try {
                log.info("second");
            } finally {
                lock.unlock();
            }
            log.info("third");
        });
        Thread.sleep(Long.MAX_VALUE);
    }
}
