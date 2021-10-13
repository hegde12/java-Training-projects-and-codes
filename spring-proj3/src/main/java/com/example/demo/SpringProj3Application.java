package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@OpenAPIDefinition(info=@Info(title="Student Management Service", version="1.0"))
public class SpringProj3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProj3Application.class, args);
	}

}
