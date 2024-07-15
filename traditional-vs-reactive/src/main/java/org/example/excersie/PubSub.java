package org.example.excersie;

import org.example.ReactiveSources;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class PubSub {
    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                num -> System.out.println(num),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
        // same as above, the allows to do backpressure control

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscription happened");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " recieved");
        request(1);
    }
}
