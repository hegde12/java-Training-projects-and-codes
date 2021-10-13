package com.inhritence.ex;

public class Book {
	private int bookNo;
	private String bookName;
	private String author;
	private double price;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookNo, String bookName, String author, double price) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.bookNo+" : "+this.bookName+" : "+this.author+" : "+this.price;
	}
}
