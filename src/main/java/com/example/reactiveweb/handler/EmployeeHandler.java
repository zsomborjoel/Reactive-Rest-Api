package com.example.reactiveweb.handler;

import com.example.reactiveweb.model.Employee;
import com.example.reactiveweb.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

    @Autowired
    private EmployeeService employeeService;

    public Mono<ServerResponse> handleEmployee(ServerRequest request) {
        Flux<Employee> employees = employeeService.listAllEmployee();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employees,Employee.class);
    }

}
