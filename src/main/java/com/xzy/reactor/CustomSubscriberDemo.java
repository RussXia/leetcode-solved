package com.xzy.reactor;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * User: RuzzZZ
 * Date: 2022/11/9
 * Time: 17:40
 */
public class CustomSubscriberDemo {

    static final class CustomSubscriber<T> extends BaseSubscriber<T> {
        private Subscription subscription;

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            this.subscription = subscription;
            System.out.println(Thread.currentThread().getName() + "- hook on subscribe");
            this.subscription.request(1);
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println(Thread.currentThread().getName() + "- hook on next,value:" + value);
            this.subscription.request(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomSubscriber<String> subscriber = new CustomSubscriber<String>();
        Flux<String> flux = Flux.just("foo", "bar", "foobar")
                .limitRate(10);
        flux.subscribe(subscriber);
        Thread.currentThread().join(100000);
    }
}
