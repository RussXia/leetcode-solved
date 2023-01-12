package com.xzy.reactor;

import reactor.core.publisher.Flux;

import java.util.Objects;

/**
 * User: RuzzZZ
 * Date: 2022/11/9
 * Time: 15:57
 */
public class FluxDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        seq1.subscribe(s -> {
                    System.out.println("do on consumer:" + s);
                    if (Objects.equals("foobar", s)) {
                        throw new RuntimeException("test-" + s);
                    }
                },
                error -> System.err.println("Error:" + error),
                () -> System.out.println("Done"));
        //seq1.doOnNext(s -> System.out.println("do on next:" + s));
        Thread.currentThread().join(10000);


    }
}
