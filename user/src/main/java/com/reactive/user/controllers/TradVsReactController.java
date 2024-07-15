package com.reactive.user.controllers;

import com.reactive.user.services.TradVsReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/api/v1/tradvsreact")
public class TradVsReactController {

    @Autowired
    private TradVsReactService tradVsReactService;

    @GetMapping("/traditional")
    public  String traditionalDemo() {
                return tradVsReactService.getHello2() + tradVsReactService.getWorld2();
    }

    @GetMapping("/reactive")
    public Mono<String> reactiveDemo() {
        return tradVsReactService.getHello()
                .zipWith(tradVsReactService.getWorld())
                .map(value -> {
                    return value.getT1() + value.getT2();
                });
    }

    @GetMapping("/completable")
    public CompletableFuture<String> compFutDemo() {
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> tradVsReactService.getHello2());
        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> tradVsReactService.getWorld2());
        return helloFuture.thenCombine(worldFuture, (hello, world)->hello+world);
    }

//    @GetMapping("/backpressure")
//    public Flux<Integer> backpressure() {
//        return tradVsReactService.handleBackpressure();
//    }
}
