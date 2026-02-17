package com.ameda.kisevu.reactive.controller.router;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: kev.Ameda
 */
@Component
public class HelloController {

    public Mono<ServerResponse> secondNamesHandler() {
        Flux<String> namesPublisher = Flux.just("Ameda "," Kisevu "," Nyangiya ");
        return ServerResponse.ok()
                .body(namesPublisher,String.class);
    }


    public Mono<ServerResponse> pathVariableHandler(ServerRequest request){
        String req = request.pathVariable("yourName");
        String  response = " Your name is "+ req;
        Mono<String> publisher = Mono.just(response);
        Mono<ServerResponse> bodyMonoResponse = ServerResponse.ok()
                .body(publisher, String.class);
        return  bodyMonoResponse;
    }

    public Mono<ServerResponse> requestParamHandler(ServerRequest request){
        Flux<String> flux = Flux.just("Software Engineer ", " Marketer ", " consultancy ");
        return   ServerResponse.ok()
                .body(flux, String.class);
    }
}
