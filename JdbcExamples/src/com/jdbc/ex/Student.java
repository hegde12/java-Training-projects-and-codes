package com.jdbc.ex;

import java.time.LocalDate;

public class Student {
	private int rollNo;
	private String name;
	private LocalDate dob;
	private int marks;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//private double marks;
	public Student(int rollNo, String name, LocalDate dob, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.marks = marks;
		System.out.println(dob);
		System.out.println(getDob());
	}
	
}
