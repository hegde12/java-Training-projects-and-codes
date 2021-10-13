package com.example.demo.emp.EmpProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
public class EmployeeUtil {
	PreparedStatement ps_ins=null,ps_upd=null,ps_del=null,ps_list=null;
	ResultSet result=null;
	Connection con=null;
	private String firstName,lastName,address,emailId,date;
	private long phNo;
	Date dateOfBirth,marriageDate;
	Scanner sc=new Scanner(System.in);
	public void insertIntoEmp()
	{
		String firstName,lastName,address,emailId;
		long phNo;
		java.sql.Date dateOfBirth;
		java.sql.Date marriageDate;
		
		try {
				con=EmployeeHelper.getConnection();
			String sql="insert into  Employee(firstName,lastName,address,emailId,phNo,dateOfBirth,marriegeDate) values(?,?,?,?,?,?,?)";
			ps_ins=con.prepareStatement(sql);
			System.out.println("Enter first name ");
			firstName=sc.next();
			System.out.println("Enter lastname");
			lastName=sc.next();
			System.out.println("Enter address");
			address=sc.next();
			System.out.println("Enter emailid");
			emailId=sc.next();
			System.out.println("Enter Phone number");
			phNo=sc.nextLong();
			System.out.println("Enter Date Of birth ");
			date=sc.next();
			dateOfBirth=java.sql.Date.valueOf(date);
			System.out.println("Enter marriage date");
			date=sc.next();
			marriageDate=java.sql.Date.valueOf(date);
			EmployeeDetails employee=new  EmployeeDetails(firstName,lastName,address,emailId,phNo,dateOfBirth,marriageDate);
			ps_ins.setString(1,employee.getFirstName());
			ps_ins.setString(2,employee.getLastName());
			ps_ins.setString(3,employee.getAddress());
			ps_ins.setString(4,employee.getEmailId());
			ps_ins.setLong(5,employee.getPhNo());
			ps_ins.setDate(6, (java.sql.Date)employee.getDateOfBirth());
			ps_ins.setDate(7,(java.sql.Date) employee.getMarriageDate());
			int b=ps_ins.executeUpdate();
			System.out.println(b);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ;
	}

}
