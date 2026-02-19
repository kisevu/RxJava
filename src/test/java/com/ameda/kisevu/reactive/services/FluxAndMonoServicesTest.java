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
}