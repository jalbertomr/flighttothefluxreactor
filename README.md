# flighttothefluxreactor
A fast introduction to flux, Project Reactor

- Nothing happens until you subscribe
- Cold vs Hot
- SubscribeON
- One benefit of scheduler
   for test
  StepVerifier.withVirtualTime(() -> Flux.range(0, 4).delayElements(Duration.ofHours(5)))
                .expectSubscription()
                .thenAwait(Duration.ofDays(1))
                .expectNextCount(4)
                .verifyComplete();

