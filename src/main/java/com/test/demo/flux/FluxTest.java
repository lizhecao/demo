package com.test.demo.flux;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @description:
 * @author: 李哲操
 * @create: 2020-09-12 13:03
 **/
public class FluxTest {
    public static void main(String[] args) throws InterruptedException {
//        Flux.just(5, 10)
//                .flatMap(x -> Flux.range(0, 1000))
//                .toStream()
//                .forEach(System.out::println);

//        final Flux<Object> flux = Flux.just("hello ");
//        flux.map(msg -> msg + "thread ")
//                .subscribeOn(Schedulers.single())
//                .subscribe(v ->
//                        System.out.println(v + Thread.currentThread().getName())
//                );
        Flux.generate(ArrayList::new, (l, sink) -> {
            Random random = new Random();
            int r = random.nextInt();
            l.add(r);
            sink.next(r);
            if (l.size() == 10) {
                sink.complete();
            }
            return l;
        }).subscribeOn(Schedulers.elastic())
                .subscribe(System.out::println, x -> System.out.println("error"), () -> System.out.println("complete"));

//        // 如何解决回调地狱的
//        Flux.just("boss1", "boss2")
//                .flatMap(x -> product(x))
//                .flatMap(x -> developer(x))
//                .flatMap(x -> test(x))
//                .flatMap(x -> ops(x))
//                .subscribe(x -> System.out.println("job done"),
//                        x -> System.out.println("job failed"));
//
//        Thread.sleep(3000);

        FluxTest fluxTest = new FluxTest();
        fluxTest.callbackHell();

        Thread.sleep(10000);
    }

    static Flux<String> product(String from) {
        System.out.println("product get jobs from " + from);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Flux.just("product", "product2").log();
    }

    static Flux<String> test(String from) {
        System.out.println("test get jobs from " + from);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Flux.just("test");
    }

    static Flux<String> developer(String from) {
        System.out.println("developer get jobs from " + from);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Flux.just("developer");
    }

    static Flux<String> ops(String from) {
        System.out.println("ops get jobs from" + from);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Flux.just("ops");
    }

    public void callbackHell() {
        System.out.println("老板发布任务");
        new Thread(() -> {
            Product product = new Product();
            product.work(x -> {
                System.out.println(x);
                new Thread(() -> {
                    Dev dev = new Dev();
                    dev.work(y -> {
                        System.out.println(y);
                        new Thread(() -> {
                            Test test = new Test();
                            test.work(z -> {
                                System.out.println(z);
                                System.out.println("喜大普奔");
                            });
                        }).start();
                    });
                }).start();
            });
        }).start();
        System.out.println("老板下班");
    }

    class Product {
        public void work(Consumer consumer) {
            System.out.println("产品 done");
            consumer.accept("message from 产品");
        }
    }

    class Dev {
        public void work(Consumer consumer) {
            System.out.println("开发 done");
            consumer.accept("message from 开发");
        }
    }

    class Test {
        public void work(Consumer consumer) {
            System.out.println("测试 done");
            consumer.accept("message from 测试");
        }
    }
}
