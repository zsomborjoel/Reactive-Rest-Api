package com.example.reactiveweb;

import com.example.reactiveweb.model.Employee;
import com.example.reactiveweb.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

import static java.util.Arrays.asList;

@SpringBootApplication
public class ReactiveWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {

		return (args) -> {
			// save a few employees
			repository.saveAll(asList(new Employee("Zsombor", "zsomborjoel@gmail.com", "+36309540376", 1),
					new Employee("Josh", "josh@gmail.com", "+36703212344", 2),
					new Employee("Elizabeth", "elizabeth@gmail.com", "+36209665445", 1)))
					.blockLast(Duration.ofSeconds(10));
		};
	}

}
