package com.example.springwebflux.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Nícolas Moura da Silva
 */
@Configuration
public class ExampleRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ExampleHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/example").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }

    @Bean
    public RouterFunction<ServerResponse> routeExampleOneStepFurther(ExampleHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/exampleFurther1").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::helloFurther1)
                .andRoute(RequestPredicates.GET("/exampleFurther2").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::helloFurther2);

    }
}
