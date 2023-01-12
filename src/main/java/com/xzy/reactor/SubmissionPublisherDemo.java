package com.xzy.reactor;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * User: RuzzZZ
 * Date: 2022/11/7
 * Time: 18:25
 */
public class SubmissionPublisherDemo {


    public static void main(String[] args) throws InterruptedException {
        //System.out.println(ForkJoinPool.commonPool().getCommonPoolParallelism());

        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        System.out.println("[executor]" + publisher.getExecutor().toString());
        Flow.Subscriber<Integer> subscriber1 = genSubscriber(true);
        Flow.Subscriber<Integer> subscriber2 = genSubscriber(false);

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + "生产数据:" + i);
            publisher.submit(i);
        }

        publisher.close();
        Thread.currentThread().join(10000L);

    }


    public static Flow.Subscriber<Integer> genSubscriber(boolean lazy) {
        return new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println(Thread.currentThread().getName() + "[onSubscribe]订阅成功!");
                subscription.request(1L);
                //System.out.println("[onSubscribe]订阅方法中请求了一个数据");
            }

            @SneakyThrows
            @Override
            public void onNext(Integer item) {
                System.out.println(Thread.currentThread().getName() + "[onNext]接受到数据:" + item);
                if (lazy) {
                    TimeUnit.MILLISECONDS.sleep(RandomUtil.randomLong(1000, 3000));
                }
                subscription.request(1L);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(Thread.currentThread().getName() + "[onError]出现异常:" + throwable.getMessage());
                subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getName() + "[onComplete]所有数据处理完毕!");
            }
        };
    }
}
