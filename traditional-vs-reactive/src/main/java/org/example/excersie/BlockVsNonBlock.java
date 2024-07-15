package org.example.excersie;

import org.example.ReactiveSources;
import org.example.StreamSources;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BlockVsNonBlock {
    public static void main(String[] args) throws IOException {
//        ----> Starting with Streams
        // Print all numbers in the intNumbersStream stream
//        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));
        // Print first names of all users in userStream
//        StreamSources.userStream().map(user -> user.getFirstName())
//                .forEach(userName -> System.out.println(userName));

        //        ---> Flux and Mono
        // Using ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
        // Print all numbers in the ReactiveSources.intNumbersFlux stream
//        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));
        // Print all users in the ReactiveSources.userFlux stream
//        ReactiveSources.userFlux().subscribe(e -> System.out.println(e));

//        -----> sending over the time blocking demonstration
//        List<Integer> intList = ReactiveSources.intNumbersFlux().toStream().toList();
//        System.out.println(intList);

//        -----> Blocking if required
        // Get the value from the Mono into an integer variable
//        Integer number = ReactiveSources.intNumberMono().block();
//        System.out.println("blocked " + number);
        // Get the value from the Mono into a String variable but give up after 5 seconds
//        String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
//        System.out.println(foo);

//        -----> Pub sub explaining


        System.out.println("Press a key to end");
//        System.in.read();
    }
}
