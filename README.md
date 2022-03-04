# flighttothefluxreactor
A fast introduction to flux, Project Reactor

https://www.youtube.com/watch?v=sNgTTcG-fEU&ab_channel=SpringDeveloper

- Nothing happens until you subscribe
  Generate Flux Data:
    Flux.range(0,4).map(DemoFluxReactor::indexToName);
  Consume it:
    flux.subscribe();
    flux.subscribe( e -> System.out.println(e));
    flux.subscribe( e -> System.out.println(e), Throwable::printStackTrace);
- Cold vs Hot
    Cold: Data generated for each subscribed receibing the hole secuence generated.
    flux.subscribe( e -> System.out.println("first subscribed " + e), Throwable::printStackTrace);
    flux.subscribe( e -> System.out.println("second subsceibed " + e), Throwable::printStackTrace);
    
    Hot: Data secuence generated flows independently of subscriber, late subscribers lost the fisrt secuence.
    ConnectableFlux<String> connFlux = Flux.range( 0, 4)
                                           .map(DemoFluxReactor::indexToName)
                                           .delayElements(Duration.ofMillis(250).publish();
    connFlux.subscribe( e -> System.out.println("flux1 received: " + e), Throwable::printStackTrace);
    connFlux.connect();
    
    connFlux.subscribe( e -> System.out.println("flux2 received: " + e), Throwable::printStackTrace);
   
    ThreadSleep(750);
    
- SubscribeON
   Scheduler.immediate()
            .parallel()
            .newParallel()  -- must be shutdown after use.
            .single()
            .elastic()
   
   Scheduler schedulerElastic = Scheduler.boundedElastic();
   flux.publishOn(schedulerElastic)
       .subscribe( e -> System.out.println("received " + e + " on thread " + Thread.currentThread().getName()));
   
- One benefit of scheduler
   for test 
  StepVerifier.withVirtualTime(() -> Flux.range(0, 4).delayElements(Duration.ofHours(5)))
                .expectSubscription()
                .thenAwait(Duration.ofDays(1))
                .expectNextCount(4)
                .verifyComplete();

