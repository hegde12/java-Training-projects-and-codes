package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
@Component("invoice")
public class Invoice {

	@Autowired
	public Customer getC() {
		return c;
	}
	@Autowired
	public void setC(Customer c) {
		this.c = c;
	}
	@Autowired
	public Product getP() {
		return p;
	}
	@Autowired
	public void setP(Product p) {
		this.p = p;
	}
	private Customer c;
	private Product p;
}
