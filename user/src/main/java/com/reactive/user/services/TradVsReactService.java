package com.reactive.user.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class TradVsReactService {

    public String getHello2() {
        // gets the name of current thread
        System.out.println("Current Thread Name: "+ Thread.currentThread().getName());

        // gets the ID of the current thread
        System.out.println("Current Thread ID: "+ Thread.currentThread().getId());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ("Hello ");
    }

    public String getWorld2() {
        // gets the name of current thread
        System.out.println("Current Thread Name: "+ Thread.currentThread().getName());

        // gets the ID of the current thread
        System.out.println("Current Thread ID: "+ Thread.currentThread().getId());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ("World!!!");
    }

    public Mono<String> getHello() {
        // gets the name of current thread
        System.out.println("Current Thread Name: "+ Thread.currentThread().getName());

        // gets the ID of the current thread
        System.out.println("Current Thread ID: "+ Thread.currentThread().getId());

        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }

    public Mono<String> getWorld() {
        // gets the name of current thread
        System.out.println("Current Thread Name: "+ Thread.currentThread().getName());

        // gets the ID of the current thread
        System.out.println("Current Thread ID: "+ Thread.currentThread().getId());

        return Mono.just("World!!!").delayElement(Duration.ofSeconds(5));
    }

    // ---> backpressure handling
//    public Flux<String> handleBackpressure() {
//        // Simulating a stream with backpressure handling
//        return Flux.range(1, 1000)
//                .onBackpressureBuffer(10)
//                .map(i -> "Element " + i);
//    }

//    public Flux<Integer> handleBackpressure() {
//        return Flux.range(1, 1000);
//                .onBackpressureBuffer(100, onBufferOverflow -> {
//                    System.out.println("Buffer overflow occurred!");
//                    // You can take custom action here, such as logging, handling, etc.
//                })
//                .doOnRequest(requested -> System.out.println("Requested: " + requested))
//                .doOnNext(element -> System.out.println("Received element: " + element))
//                .map(i -> "Element " + i);
//    }
}
