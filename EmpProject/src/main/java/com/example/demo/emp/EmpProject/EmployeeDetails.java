package com.example.demo.emp.EmpProject;

import java.sql.Date;

public class EmployeeDetails {
	private String firstName,lastName,address,emailId;
	private long phNo;
	Date dateOfBirth,marriageDate;
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetails(String firstName, String lastName, String address, String emailId, long phNo,
			Date dateOfBirth, Date marriageDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.phNo = phNo;
		this.dateOfBirth = dateOfBirth;
		this.marriageDate = marriageDate;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getMarriageDate() {
		return marriageDate;
	}
	public void setMarriageDate(Date marriageDate) {
		this.marriageDate = marriageDate;
		
	}
	@Override
	public String toString() {
		return "EmployeeDetails [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailId=" + emailId + ", phNo=" + phNo + ", dateOfBirth=" + dateOfBirth + ", marriageDate="
				+ marriageDate + "]";
	}

}
