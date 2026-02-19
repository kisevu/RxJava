package com.ameda.kisevu.reactive.services;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class FluxAndMonoServices {

    public static void main(String[] args) {

        FluxAndMonoServices obj = new FluxAndMonoServices();
        obj.fluxFamily().subscribe((value)-> {
             log.info(" Name -> {}", value);
        });
    }

    public Flux<String> fluxFamily(){
        return Flux.fromIterable(List.of("Kevin Ameda Kisevu",
                "Judith Nyangiya Kisevu","Pers Lindoe Kisevu")).log();
    }
}
