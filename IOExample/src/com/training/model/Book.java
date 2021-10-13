package com.training.model;

public class Book {
	private int bookNumber;
	private double price;
	private String name;
	public Book(int bookNumber, double price, String name) {
		super();
		this.bookNumber = bookNumber;
		this.price = price;
		this.name = name;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	@Override
	public String toString() {
		return   "bookNumber"+ ","+ price + ","+ name ;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
