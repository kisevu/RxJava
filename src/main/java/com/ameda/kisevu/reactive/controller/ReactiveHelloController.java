package com.ameda.kisevu.reactive.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.List;

/**
 * Author: kev.Ameda
 */
//@RestController
public class ReactiveHelloController {


    @GetMapping("/hello")
    public  Flux<String> helloWorld(){
        List<String> names = List.of("Kevin","Ameda","Kisevu");
        Flux<String> publisher = Flux.fromIterable(names)
                .delayElements(Duration.ofMillis(20))
                .log();
        return publisher;
    }

    @GetMapping("/welcome")
    public List<String> names() throws InterruptedException {
        List<String> names = List.of("Kevin","Ameda","Kisevu");
        Thread.sleep(20000);
        return names;
    }




}
