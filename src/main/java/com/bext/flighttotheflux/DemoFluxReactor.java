package com.bext.flighttotheflux;

import reactor.core.publisher.Flux;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class DemoFluxReactor {
    private static String[] ARRAYSTRING = new String[]{
            "String-0",
            "String-1",
            "String-2",
            "String-3"
    };

    private static String indexToName(@NotNull Integer i){
        //System.out.println("getting element [" + i + "] from thread" + Thread.currentThread().getName());
        return ARRAYSTRING[i];
    }

    public static void main(String[] args) throws InterruptedException{
        //TODO 1 - Nothing happens until you subscribe
        Flux<String> flux = Flux.range(0, 4)
                .map(DemoFluxReactor::indexToName);

        System.out.println();
        //TODO 2 - Cold vs Hot
        AtomicInteger count = new AtomicInteger();

        Flux<Object> generate = Flux.generate(sink -> sink.next(count.incrementAndGet()));

        generate.take(4).subscribe(e -> System.out.println("flux1 received: " +e), Throwable::printStackTrace);
        generate.take(4).subscribe(e -> System.out.println("flux2 received: " +e), Throwable::printStackTrace);

        System.out.println();
        //TODO 3 - PublishOn

        System.out.println();
        //TODO 4 - SubscribeON

        System.out.println();
        //TODO 5 - One benefit of scheduler

    }

}
