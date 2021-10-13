package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

@Configuration
public class ApplicationConfig {
	@Bean
	public Customer ram()
	{
		return new Customer(101,"Gireesh",900988789);
		
	}
	@Bean(name="sony")
	public Product tv()
	{
		return new Product(111,"Sony tv",5000);
	}
}
