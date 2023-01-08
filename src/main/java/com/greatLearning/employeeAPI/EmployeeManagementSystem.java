package com.greatLearning.employeeAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementSystem implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystem.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is working");
	}
}
