package com.xzy.reactor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * User: RuzzZZ
 * Date: 2022/11/8
 * Time: 15:07
 */
public class CustomProcessorDemo {

    static class CustomProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<Integer, Integer> {

        private Flow.Subscription subscription;

        private final String name;

        private final int mod;

        public CustomProcessor(String name, int mod) {
            super();
            this.name = name;
            this.mod = mod;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            System.out.println("[processor-" + name + "]\t[onSubscribe]-订阅成功");
            subscription.request(1);
        }

        @Override
        public void onNext(Integer item) {
            System.out.println("[processor-" + name + "]\t[onNext]-收到数据:" + item);
            if (item % mod == 0) {
                this.submit(item);
            }
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("[processor-" + name + "]\t[onError]出现异常:" + throwable.getMessage());
            this.subscription.cancel();
        }

        @Override
        public void onComplete() {
            System.out.println("[processor-" + name + "]\t[onComplete]所有数据处理完毕!");
            this.close();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        CustomProcessor processor1 = new CustomProcessor("mod2", 2);
        publisher.subscribe(processor1);

        CustomProcessor processor2 = new CustomProcessor("mod3", 3);
        processor1.subscribe(processor2);

        Flow.Subscriber<Integer> subscriber = SubmissionPublisherDemo.genSubscriber(true);
        processor2.subscribe(subscriber);


        for (int i = 0; i < 100; i++) {
            publisher.submit(i);
        }
        publisher.close();
        Thread.currentThread().join(10000000L);

    }
}
