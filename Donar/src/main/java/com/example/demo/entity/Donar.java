package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donar")
public class Donar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donarid;
	
	@Column(name = "donarname")
	private String donarname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "dateofbirth")
	private LocalDate dateofbirth;
	
	@Column(name = "bloodgroup")
	private String bloodgroup;
	
	@Column(name = "lastblooddonationdate")
	private LocalDate lastblooddonationdate;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "phoneno")
	private Long phoneno;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	
	public int getDonarid() {
		return donarid;
	}


	public void setDonarid(int donarid) {
		this.donarid = donarid;
	}


	public String getDonarname() {
		return donarname;
	}


	public void setDonarname(String donarname) {
		this.donarname = donarname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public LocalDate getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getBloodgroup() {
		return bloodgroup;
	}


	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}


	public LocalDate getLastblooddonationdate() {
		return lastblooddonationdate;
	}


	public void setLastblooddonationdate(LocalDate lastblooddonationdate) {
		this.lastblooddonationdate = lastblooddonationdate;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public Long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Donar() {
		
	}
	public Donar(String donarname, String gender, int age, LocalDate dateofbirth, String bloodgroup,
			LocalDate lastblooddonationdate, String emailid, Long phoneno, String state, String city) {
		super();
		this.donarname = donarname;
		this.gender = gender;
		this.age = age;
		this.dateofbirth = dateofbirth;
		this.bloodgroup = bloodgroup;
		this.lastblooddonationdate = lastblooddonationdate;
		this.emailid = emailid;
		this.phoneno = phoneno;
		this.state = state;
		this.city = city;
	}


}
