package com.ameda.kisevu.reactive.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
class FluxAndMonoServicesTest {

    FluxAndMonoServices  fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fluxFamily() {
        var familyFlux = fluxAndMonoServices.fluxFamily();
        StepVerifier.create(familyFlux)
                .expectNext("Kevin Ameda Kisevu","Judith Nyangiya Kisevu",
                        "Pers Lindoe Kisevu")
                .verifyComplete();

    }
}