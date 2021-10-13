package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringIocApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringIocApplication.class, args);
		
		Customer c= ctx.getBean(Customer.class);
		log.info(c.toString());
		Product p=ctx.getBean("sony",Product.class);
		log.info(p.toString());
		Invoice i=ctx.getBean(Invoice.class);
		log.info(i.toString());
		ctx.close();
	}

}
