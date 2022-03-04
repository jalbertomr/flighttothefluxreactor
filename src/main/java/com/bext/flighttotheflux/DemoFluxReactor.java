package com.bext.flighttotheflux;

import reactor.core.publisher.Flux;

import javax.validation.constraints.NotNull;

public class DemoFluxReactor {
    private static String[] ARRAYSTRING = new String[]{
            "String-0",
            "String-1",
            "String-2",
            "String-3"
    };

    private static String indexToName(@NotNull Integer i){
        System.out.println("getting element [" + i + "] from thread" + Thread.currentThread().getName());
        return ARRAYSTRING[i];
    }

    public static void main(String[] args) throws InterruptedException{
        //TODO 1 - Nothing happens until you subscribe
        Flux<String> flux = Flux.range(0, 4)
                .map(DemoFluxReactor::indexToName);
        //Nothing happens until subscribe()

        System.out.println();
        //TODO 2 - Cold vs Hot

        System.out.println();
        //TODO 3 - PublishOn

        System.out.println();
        //TODO 4 - SubscribeON

        System.out.println();
        //TODO 5 - One benefit of scheduler

    }

}
