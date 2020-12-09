package com.test.demo.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

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

        final Flux<String> flux = Flux.just("hello ");

        flux.map(msg -> msg + "thread ")
                .subscribeOn(Schedulers.single())
                .subscribe(v ->
                        System.out.println(v + Thread.currentThread().getName())
                );
        Thread.sleep(3000);
    }
}
