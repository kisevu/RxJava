package com.ameda.kisevu.reactive.services;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;

@Slf4j
public class FluxAndMonoServices {

    public static void main(String[] args) {

        FluxAndMonoServices obj = new FluxAndMonoServices();
        obj.fluxFruitFlatMapAsync()
                .subscribe(System.out::println);
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

    /**
    * filter() operator
    * */
    public Flux<Person> fluxFamilyfilter(){
        return Flux.fromIterable(List.of(
                new Person("Kevin",29),
                new Person("Judith",27),
                new Person("Lindoe",2)
        )).filter( person -> {
            if ( person.getAge() < 20 ){
                return true;
            }
            return false;
        }).log();
    }

    /**
    * flatmap() operator
    * */

    public Flux<String> fluxFruitsFlatMap(){
        return Flux.fromIterable(List.of("Mango","Pineapple","Kiwi"))
                .flatMap( str -> Flux.just(str.split("")))
                .log();
    }

    /**
     * flatmap async
    * */
    public Flux<String> fluxFruitFlatMapAsync(){
        return Flux.fromIterable(List.of("Mango","watermelon","apple"))
                .flatMap( str -> Flux.just(str.split(""))
                        .delayElements(Duration.ofMillis(
                                new Random().nextInt(1000)
                        )))
                .log();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    static class Person {
        private String name;
        private int age;
    }



}
