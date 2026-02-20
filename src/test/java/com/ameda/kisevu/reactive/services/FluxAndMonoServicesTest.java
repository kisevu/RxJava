package com.ameda.kisevu.reactive.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServicesTest {

    FluxAndMonoServices  fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fluxFamilyMap() {
        var familyFlux = fluxAndMonoServices.fluxFamilyMap();
        StepVerifier.create(familyFlux)
                .expectNext("KEVIN AMEDA KISEVU","JUDITH NYANGIYA KISEVU",
                        "PERS LINDOE KISEVU")
                .verifyComplete();

    }

    @Test
    void fluxFamilyFilter(){
        var fluxFamilyfilter = fluxAndMonoServices.fluxFamilyfilter();
        StepVerifier.create(fluxFamilyfilter)
                .expectNext(FluxAndMonoServices.Person.builder()
                        .name("Lindoe")
                        .age(2)
                        .build())
                .verifyComplete();
    }

    @Test
    void fluxFruitsFlatMap(){
        var fluxFruitsFlatMap = fluxAndMonoServices.fluxFruitsFlatMap();
        StepVerifier.create(fluxFruitsFlatMap)
                .expectNextCount(18)
                .verifyComplete();
    }

    @Test
    void fluxFruitFlatMapAsync() {
        var fluxFruitsFlatMap = fluxAndMonoServices.fluxFruitFlatMapAsync();
        StepVerifier.create(fluxFruitsFlatMap)
                .expectNextCount(20)
                .verifyComplete();
    }
}