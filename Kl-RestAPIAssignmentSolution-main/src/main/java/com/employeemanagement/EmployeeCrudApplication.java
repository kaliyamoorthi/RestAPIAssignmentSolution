package com.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EntityScan("com.employeemanagement.entity")
//@ComponentScan("com.employeemanagement.*")
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudApplication.class, args);
	}

}
