package com.example.demo;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;



public class JDBCImpl implements CRUDrepository<Employee, LocalDate,String> {
	private Connection con;
	Logger log=Logger.getRootLogger();
	
	
	public JDBCImpl(Connection con)
	{
		super();
		this.con = con;
	}
	@Override
	public boolean add(Employee t) {
		String sql="insert into empdetails values(?,?,?,?,?,?,?)";
		   int rowAdded=0;
		   try(PreparedStatement pstmt=con.prepareStatement(sql) ){
			  
			   pstmt.setString(1,t.getFirstName());
			   pstmt.setString(2,t.getLastName());
			   pstmt.setString(3,t.getAddress());
			   pstmt.setString(4,t.getEmail());
			   pstmt.setLong(5,t.getPhone());
			   pstmt.setDate(6,Date.valueOf(t.getBirthday()));
			   pstmt.setDate(7,Date.valueOf(t.getWeddingAnniversary()));
			   
			   
			   rowAdded=pstmt.executeUpdate();
			   
			   
		   }catch(SQLException e) {
			   log.debug(e.getMessage());
			   e.printStackTrace();
			   
		   }
		   
			return rowAdded==1?true:false;
	
	}
	@Override
	public Employee findByName(String t)   {
		String sql="select * from empdetails where firstName=?";
       Employee obj=null;
       try(PreparedStatement pstmt=con.prepareStatement(sql)) {
			pstmt.setString(1,t);
             ResultSet rs=pstmt.executeQuery();
             if(rs.next()) {
           	  
           	String firstName=rs.getString("firstName");
           	if(firstName.equals(t)) { 
           	String lastName=rs.getString("lastName");
           	String address=rs.getString("address");
           	String emailAddress=rs.getString("email");
 				long phoneNumber=rs.getLong("phone");
				LocalDate birthday=rs.getDate("birthday").toLocalDate();
				LocalDate weddingAnniversary=rs.getDate("weddingAnniversary").toLocalDate();
				obj =new Employee(firstName,lastName,address,emailAddress,phoneNumber,birthday,weddingAnniversary);
				}}
				else {
					log.error("Invalid name entered");
					
					throw new NameNotFoundException("no such records");
				}
			
		} catch (NameNotFoundException|SQLException e1) {
			log.debug(e1.getMessage());
			e1.printStackTrace();
		}
		return obj;
		
	}
	

	@Override
	public List<Employee> findAll() {
		String sql="select firstName,phone from empdetails";
       List<Employee> list=new ArrayList<Employee>();
       try(PreparedStatement pstmt=con.prepareStatement(sql)) {
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName=rs.getString("firstName");
				long phoneNumber=rs.getLong("phone");
				
				Employee emp =new Employee(firstName,phoneNumber);
					list.add(emp);
					
			}
		} catch (Exception e) {
			
			log.debug(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(){
		    int r=0;
			Scanner sc=new Scanner(System.in);
			//input employee id by which we are going to edit record
			log.debug("Enter Employee First name:");
			String name=sc.next();

			//query to take data of a particular record from table employee
			String q="Select * from empdetails where firstName='"+name+"'";
			try(PreparedStatement pstmt=con.prepareStatement(q) ){
			//to execute query
			ResultSet rs=pstmt.executeQuery(q);
			if(rs.next())
			{
				//to show the data
				
				log.info("Employee  First Name:"+rs.getString(1));
				log.info("1.Employee Last Name:"+rs.getString(2));
				log.info("2.Employee Address:"+rs.getString(3));
				log.info("3.Employee email Address:"+rs.getString(4));
				log.info("4.Employee phone number:"+rs.getLong(5));
				log.info("5.Employee Birth date:"+rs.getString(6));
				log.info("6.Employee wedding date:"+rs.getString(7));
				log.info("7: exit! ");
				log.info("Which Field U Want to Edit? select option number");
				int ch=sc.nextInt();
				log.info("the entered choice is :"+ch);
				String pat="";
				//cases to choose field you want to edit
				switch(ch)
				{ 
					case 1:
						System.out.print("Enter New  last Name:");
						String newlastName=sc.next();
						pat="lastName='"+newlastName+"'";
						break;

					case 2:
						System.out.print("Enter New address");
						String newaddress=sc.next();
						pat="address='"+newaddress+"'";
						break;

					case 3:
						System.out.print("Enter New email Address");
						String newemailId=sc.next();
						pat="email='"+newemailId+"'";
						break;

					case 4:
						System.out.print("Enter New phone number");
						long newphoneNumber=sc.nextLong();
						pat="phone="+newphoneNumber;
						break;
					case 5:
						System.out.print("Enter New wedding date");
						String newWd=sc.next();
						//LocalDate birth = LocalDate.parse(newDob);
						pat="weddingAnniversary="+"'"+newWd+"'";
						break;
						
					case 6:
						System.out.print("Enter New Date of Birth");
						String newDob=sc.next();
						//LocalDate birth = LocalDate.parse(newDob);
						pat="birthday="+"'"+newDob+"'";
						break;

					case 7:
						System.out.println("Exit");
						break;

					default:
						log.info("Wrong Option");
						break;
				}
				if(!pat.equals(""))
				{
					//query to edit data of a particular record from table employee
					q="update empdetails set "+pat+" where firstName='"+name+"'";
					//to execute update
					pstmt.executeUpdate(q);
					log.info("Record Updated....");
					r=1;
				}
			} 
			else
			{  log.error("Invalid information entered");
				throw new NameNotFoundException("Record Not Found... for the employee :"+name);
				
			}
			}catch (NameNotFoundException |SQLException   e1) {
				log.debug(e1.getMessage());
				e1.printStackTrace();
			}
			return r;
		}
		@Override
	public void findByBirthday(LocalDate e) {
		String sql="select firstName,email from empdetails where birthday=?";
       Employee obj=null;
       
       try(PreparedStatement pstmt=con.prepareStatement(sql)) {
			pstmt.setDate(1,Date.valueOf(e));
             ResultSet rs=pstmt.executeQuery();
             if(rs.next()) {
           	  
           	  log.info("Name of the Employee: "+rs.getString("firstName")+", ");
                 log.info("Email ID: "+rs.getString("email"));
                 
 			  
		} }catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	

	@Override
	public void findByWeddingAnniversery(LocalDate e) {

		String sql="select firstName,phone from empdetails where weddingAnniversary=?";
       Employee obj=null;
       
       try(PreparedStatement pstmt=con.prepareStatement(sql)) {
			pstmt.setDate(1,Date.valueOf(e));
             ResultSet rs=pstmt.executeQuery();
             if(rs.next()) {
           	  
           	  log.info("Name of the Employee: "+rs.getString("firstName")+", ");
           	  log.info("Phone Number :"+rs.getLong("phone"));
           	  
		} }catch (Exception e1) {
			e1.printStackTrace();
		}
			
	}

}
