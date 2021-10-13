package com.example.employee;

import java.time.LocalDate;

public class Employee {

	private int EmpId;
	private String FirstName;
	private String LastName;
	private String Address;
	private String EmailAddress;
	private long PhoneNumber;
	private LocalDate BirthDays;
	private LocalDate WeddingAnniversary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId) {
		this.EmpId=empId;
	}
	public Employee(int empId, String firstName, String lastName, String address, String emailAddress, long phoneNumber,
			LocalDate birthDays, LocalDate weddingAnniversary) {
		super();
		EmpId = empId;
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		EmailAddress = emailAddress;
		PhoneNumber = phoneNumber;
		BirthDays = birthDays;
		WeddingAnniversary = weddingAnniversary;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public LocalDate getBirthDays() {
		return BirthDays;
	}
	public void setBirthDays(LocalDate birthDays) {
		BirthDays = birthDays;
	}
	public LocalDate getWeddingAnniversary() {
		return WeddingAnniversary;
	}
	public void setWeddingAnniversary(LocalDate weddingAnniversary) {
		WeddingAnniversary = weddingAnniversary;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Address="
				+ Address + ", EmailAddress=" + EmailAddress + ", PhoneNumber=" + PhoneNumber + ", BirthDays="
				+ BirthDays + ", WeddingAnniversary=" + WeddingAnniversary + "]";
	}
	
	
}
