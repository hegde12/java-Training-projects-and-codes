package com.example.rest_service;

import jakarta.ws.rs.Path;

@Path(value="abc")
public class Student {
	private int rollNo;
	private String name;
	private double marksScored;
	public Student(int rollNo, String name, double marksScored) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marksScored = marksScored;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}

}
