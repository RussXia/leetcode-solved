package com.xzy.reactor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * User: RuzzZZ
 * Date: 2023/4/19
 * Time: 16:54
 */
@Slf4j
public class CompletableFutureDemo2 {

    private final static int AVAILABLE_PROCESSOR = Runtime.getRuntime().availableProcessors();

    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVAILABLE_PROCESSOR,
            AVAILABLE_PROCESSOR * 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
            new ThreadFactoryBuilder().setNameFormat("custom-thread-pool_%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());
    private final static ThreadPoolExecutor POOL_EXECUTOR2 = new ThreadPoolExecutor(AVAILABLE_PROCESSOR,
            AVAILABLE_PROCESSOR * 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
            new ThreadFactoryBuilder().setNameFormat("custom2-thread-pool_%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Supplier<String> supplier = () -> {
            long current = System.currentTimeMillis();
            log.info("supplier--->{}", current);
            return "" + System.currentTimeMillis();
        };
        CompletableFuture<String> future1 = CompletableFuture.completedFuture(supplier.get());
        CompletableFuture<String> future2 = CompletableFuture.completedFuture(supplier.get());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    log.info("set future result");
                    return "hello111";
                }, POOL_EXECUTOR)
                .thenApply(result -> {
                    log.info("thenApply-->before result:{}", result);
                    return supplier.get();
                }).thenCompose(result -> {
                    log.info("before result:{}", result);
                    return CompletableFuture.completedFuture(supplier.get());
                }).thenCompose(result -> {
                    log.info("before result:{}", result);
                    return future1;
                }).thenCompose(result -> {
                    log.info("before result:{}", result);
                    return future2;
                });
        log.info("final result:{}", future.get());

    }

    private static void demo7() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future1 result--", Thread.currentThread().getName());
            return "hello111";
        });
        log.info("result:{}", future1.get());
        log.info("result:{}", future1.get());
        log.info("result:{}", future1.get());
        log.info("result:{}", future1.get());
    }

    private static void demo6() {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                Thread.sleep(1000L);
                throw new RuntimeException("ddd");
                //future.complete("ok");
            } catch (Exception e) {
                future.completeExceptionally(e);
            }

        }).start();
        log.info("result:{}", future.exceptionally(t -> {
            log.info("throwable:{}", t.getMessage());
            return "default";
        }));
    }

    private static void demo5() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future1 result--", Thread.currentThread().getName());
            return "hello111";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future2 result--", Thread.currentThread().getName());
            return "hello222";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future3 result--", Thread.currentThread().getName());
            return "hello333";
        });
        System.out.println(CompletableFuture.anyOf(future1, future2, future3).get());
    }

    private static void demo4() throws ExecutionException, InterruptedException {
        // thenApply是同步mapping;thenCompose是异步mapping
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            //try {
            //    Thread.sleep(3000);
            //} catch (Exception e) {
            //    e.printStackTrace();
            //}
            log.info("supplyAsync---> \t{}\t set future result--", Thread.currentThread().getName());
            return "hello111";
        }, POOL_EXECUTOR).thenApply(result -> {
            log.info("thenApply---> \tget result :{},return length", result);
            return result.length();
        }).thenComposeAsync(result -> {
            log.info("thenCompose1---> \tget length:{},return result", result);
            return CompletableFuture.completedFuture("length-" + result);
        }, POOL_EXECUTOR2).thenCompose(result -> {
            log.info("thenCompose2---> \tget length:{},return result", result);
            return CompletableFuture.completedFuture("length-" + result);
        });
        log.info("get:{}", future.get());
    }

    private static void demo3() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future result--", Thread.currentThread().getName());
            throw new RuntimeException("test_1111");
        }).handle((result, e) -> {
            log.info("result:{}, e:{}", result, e.getMessage());
            throw new RuntimeException("test_222");
        });
        log.info("get:{}", future.get());
    }

    private static void demo2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future result--", Thread.currentThread().getName());
            return "this is result";
        }).thenApply(s -> {
            log.info("{}\t get future result:{}", Thread.currentThread().getName(), s);
            return "this is an another result";
        });
        log.info("{}\t start--", Thread.currentThread().getName());
        log.info("result:{}", future.get());
    }

    private static void demo() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        POOL_EXECUTOR.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("{}\t set future result--", Thread.currentThread().getName());
            future.complete("this is result");
        });
        log.info("{}\t wait future result--", Thread.currentThread().getName());
        log.info("result:{}", future.get());
        log.info("{}\t over--", Thread.currentThread().getName());
        POOL_EXECUTOR.shutdown();
    }
}
