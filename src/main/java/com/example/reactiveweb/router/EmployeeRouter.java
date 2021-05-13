package com.example.reactiveweb.router;

import com.example.reactiveweb.handler.EmployeeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> productListing(EmployeeHandler employeeHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/employee").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), employeeHandler::handleEmployee);
    }

}
