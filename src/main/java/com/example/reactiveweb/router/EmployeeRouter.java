package com.example.reactiveweb.router;

import com.example.reactiveweb.handler.EmployeeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> employeeListing(EmployeeHandler employeeHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/employee").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), request -> employeeHandler.handleEmployee());
    }

}
