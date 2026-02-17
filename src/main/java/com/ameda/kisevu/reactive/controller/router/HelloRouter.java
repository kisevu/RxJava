package com.ameda.kisevu.reactive.controller.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Author: kev.Ameda
 */
@Configuration
public class HelloRouter {

    private final HelloController helloController;

    public HelloRouter(HelloController helloController) {
        this.helloController = helloController;
    }

    /**
     * Rest calls with Router with reactive
    * */

    @Bean
    public RouterFunction<ServerResponse> HelloRouter(){
        RequestPredicate request = RequestPredicates.GET("/hello");
        HandlerFunction<ServerResponse> handlerFunction = new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                Flux<String> namesPublisher = Flux.just("Kevin", "Lindoe", "Judith");

//                        .delayElements(Duration.ofSeconds(1));
                Mono<ServerResponse> serverResponseMono = ServerResponse
                        .ok()
//                        .contentType(MediaType.TEXT_EVENT_STREAM)  /
                        .body(namesPublisher, String.class);
                return serverResponseMono;
            }
        };
        RouterFunction<ServerResponse> routeFunction = RouterFunctions.route(request, handlerFunction);
        return routeFunction;
    }

    //functional variant
    @Bean
    public RouterFunction<ServerResponse> worldRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/second-names"),
                request -> helloController.secondNamesHandler());
    }

    //path variable
    @Bean
    public RouterFunction<ServerResponse> pathRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/me/{yourName}"),
                request ->  helloController.pathVariableHandler(request))
                .andRoute(RequestPredicates.GET("/data"), request ->  helloController.requestParamHandler(request));
    }


}
