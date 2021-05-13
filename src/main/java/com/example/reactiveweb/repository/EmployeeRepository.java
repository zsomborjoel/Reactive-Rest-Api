package com.example.reactiveweb.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.reactiveweb.model.Employee;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {

    @Query("SELECT * FROM employee WHERE name = :name")
    Flux<Employee> findByName(String name);

}
