package com.example.demo.data;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
//@Entity
//@Table(name = "student")
public class Student {

//	@Id //primarykey
//	@Column(name = "rollnumber")
	@Range(max=1000,min=100,message="number should be 100 to 1000")
	int rollNumber;
//	@Column(name = "studname")
	@Length(min=3,max=20,message="name should be 3 to 20 characters")
	String studentName;
//	@Column(name="dateofbirth")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate dateOfBirth;
//	@Column(name = "markscored")
	double markScored;
}
