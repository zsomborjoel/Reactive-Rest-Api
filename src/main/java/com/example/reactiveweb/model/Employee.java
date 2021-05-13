package com.example.reactiveweb.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
public class Employee {

    @Id
    private Long id;

    private String name;

    private String email;

    private String phone;

    private int department;
    
    public Employee(String name, String email, String phone, int department) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

}
