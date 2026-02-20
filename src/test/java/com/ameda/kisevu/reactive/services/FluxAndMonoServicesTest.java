package com.ameda.kisevu.reactive.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

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

    @Test
    void monoFruitFlatMap() {
        var listMono = fluxAndMonoServices.monoFruitFlatMap();
        StepVerifier.create(listMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void fluxFruitConcatMap() {
       var fluxConcatMapAsync = fluxAndMonoServices.fluxFruitConcatMap();
       StepVerifier.create(fluxConcatMapAsync)
               .expectNextCount(13)
               .verifyComplete();
    }

    @Test
    void monoToFluxFlatMapMany() {
        var fluxFlatMapMany = fluxAndMonoServices.monoToFluxFlatMapMany();
        StepVerifier.create(fluxFlatMapMany)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void fluxFruitTransform() {
      var fluxTransform  = fluxAndMonoServices.fluxFruitTransform(5);
      StepVerifier.create(fluxTransform)
              .expectNext("Orange")
              .verifyComplete();
    }
}