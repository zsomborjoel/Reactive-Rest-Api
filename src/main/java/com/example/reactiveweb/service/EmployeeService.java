package com.example.reactiveweb.service;

import com.example.reactiveweb.model.Employee;
import com.example.reactiveweb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Flux<Employee> listAllEmployee() {
        return employeeRepository.findAll();
    }

}
