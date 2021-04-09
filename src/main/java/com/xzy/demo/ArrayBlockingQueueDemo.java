package com.xzy.demo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class ArrayBlockingQueueDemo {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        ArrayBlockingQueueDemo test = new ArrayBlockingQueueDemo();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "-从队列取走一个元素" + queue.take() + "，队列剩余元素：" + queue.size());
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "-向队列取中插入一个元素:" + queue.offer(1) + "，队列剩余元素：" + ( queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
