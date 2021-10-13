package com.example.demo.entity;

import java.time.LocalDate;

public class Employee {
	
	 private int id;
     private String firstName;
     private String lastName;
     private String address;
     private String emailAddress;
     private LocalDate weddingAnniversary;
     private String phoneNumber;
     private LocalDate birthDate;
     
 
     
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String firstName, String lastName, String address, String emailAddress,
			LocalDate weddingAnniversary, String phoneNumber, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.weddingAnniversary = weddingAnniversary;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public LocalDate getWeddingAnniversary() {
		return weddingAnniversary;
	}
	public void setWeddingAnniversary(LocalDate weddingAnniversary) {
		this.weddingAnniversary = weddingAnniversary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailAddress=" + emailAddress + ", weddingAnniversary=" + weddingAnniversary + ", phoneNumber="
				+ phoneNumber + ", birthDate=" + birthDate + "]";
	}
	
	

}
