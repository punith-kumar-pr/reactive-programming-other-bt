package org.example.excersie;

import org.example.ReactiveSources;

import java.io.IOException;

public class Operators {
    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(num -> num > 5)
                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter(num -> num > 5)
//                .map(num -> num * 10)
//                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
//        ReactiveSources.intNumbersFlux()
//                .filter(num -> num > 5)
//                .take(3)
//                .map(num -> num * 10)
//                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
//        ReactiveSources.intNumbersFlux()
//                .filter(e -> e > 20)
//                .defaultIfEmpty(-1)
//                .subscribe(n -> System.out.println(n));

        // Switch ints from intNumbersFlux to the right user from userFlux
//        ReactiveSources.intNumbersFlux()
//                .flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id))
//                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .log()
//                .distinct()
//                .subscribe();

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .log()
//                .distinctUntilChanged()
//                .subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }
}

