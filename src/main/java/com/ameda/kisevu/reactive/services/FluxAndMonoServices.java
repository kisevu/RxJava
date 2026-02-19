package com.ameda.kisevu.reactive.services;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class FluxAndMonoServices {

    public static void main(String[] args) {

        FluxAndMonoServices obj = new FluxAndMonoServices();
        obj.fluxFamilyMap().subscribe((value)-> {
             log.info(" Name -> {}", value);
        });
    }

    /**
     * Operators: We have got different operators to use in Flux and Mono
     *  a) map()  used to transfer data you are getting into a different form of data but same publisher Flux. i.e String, Integer etc.
     *
     * */
    public Flux<String> fluxFamilyMap(){
        return Flux.fromIterable(List.of("Kevin Ameda Kisevu",
                "Judith Nyangiya Kisevu","Pers Lindoe Kisevu"))
                .map(String::toUpperCase)
                .log();
    }



}
