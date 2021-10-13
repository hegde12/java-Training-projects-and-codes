package com.example.demo;

import java.time.LocalDate;

public class Employee {
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private long phone;
	private LocalDate birthday;
	private LocalDate weddingAnniversary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName, String address, String email, long phone, LocalDate birthday,
			LocalDate weddingAnniversary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.weddingAnniversary = weddingAnniversary;
	}
	public Employee(String firstName, long phoneNumber)  {
		super();
		
		this.firstName = firstName;
		this.phone=phoneNumber;
	}
	
	public Employee(String firstName, String emailAddress)  {
		super();
		
		this.firstName = firstName;
		this.email=emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public LocalDate getWeddingAnniversary() {
		return weddingAnniversary;
	}
	public void setWeddingAnniversary(LocalDate weddingAnniversary) {
		this.weddingAnniversary = weddingAnniversary;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email="
				+ email + ", phone=" + phone + ", birthday=" + birthday + ", weddingAnniversary=" + weddingAnniversary
				+ "]";
	}
	

}
