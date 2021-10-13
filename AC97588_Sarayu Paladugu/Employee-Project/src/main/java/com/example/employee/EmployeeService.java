package com.example.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import com.example.stmt.Repository;

public class EmployeeService implements Repository<Employee,Integer,String,Date> {

	Logger log=Logger.getRootLogger();
	private Connection conn;
	public EmployeeService(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean add(Employee t) {
		String sql="insert into Employee values(?,?,?,?,?,?,?,?)";
		int rowAdded=0;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, t.getEmpId());
			pstmt.setString(2,t.getFirstName());
			pstmt.setString(3,t.getLastName());
			pstmt.setString(4,t.getAddress());
			pstmt.setString(5,t.getEmailAddress());
			pstmt.setLong(6, t.getPhoneNumber());
			pstmt.setDate(7,Date.valueOf(t.getBirthDays()));
			pstmt.setDate(8,Date.valueOf(t.getWeddingAnniversary()));
			rowAdded=pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				return rowAdded==1?true:false;
	}

	public List<Employee> findAll() {
		String sql="select * from Employee";
		List<Employee> list=new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				int empId=rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String address=rs.getString("Address");
				String emailAddress=rs.getString("EmailAddress");
				long phoneNumber=rs.getLong("PhoneNumber");
				LocalDate birthDays=rs.getDate("BirthDays").toLocalDate();
				LocalDate weddingAnniversary=rs.getDate("WeddingAnniversary").toLocalDate();
				Employee employee=new Employee(empId, firstName, lastName, address, emailAddress, phoneNumber, birthDays, weddingAnniversary);
				list.add(employee);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	public int Update(Employee t) {
		String sqlUpdate = "update Employee set Address=? where EmpId =?";
    	int rowupdate=0;
        try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
        	 pstmt.setString(1,t.getAddress());
        	 pstmt.setInt(2,t.getEmpId());
			rowupdate=pstmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
		return rowupdate;
	}
	
	public Employee findById(Integer e) {
		String sql="select * from Employee where EmpId=?";
		Employee obj=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1,e);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int empId=rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String address=rs.getString("Address");
				String emailAddress=rs.getString("EmailAddress");
				long phoneNumber=rs.getLong("PhoneNumber");
				LocalDate birthDays=rs.getDate("BirthDays").toLocalDate();
				LocalDate weddingAnniversary=rs.getDate("WeddingAnniversary").toLocalDate();
				obj=new Employee(empId, firstName, lastName, address, emailAddress, phoneNumber, birthDays, weddingAnniversary);
			}
			}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return obj;
	}
	public List<Employee> findFNPN() {
		String sql="select * from Employee";
		List<Employee> list=new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String firstName=rs.getString("FirstName");
				long phoneNumber=rs.getLong("PhoneNumber");
				log.info("Employee Name: "+firstName+", Phone Number : "+phoneNumber);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	public boolean remove(Employee t) {

		String sql="delete from Employee where EmpId=?";
		int rowDeleted=0;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, t.getEmpId());
			rowDeleted=pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
				return rowDeleted==1?true:false;
	}
	public Employee findByFirstName(String FirstName) {
		String sql="select * from Employee where FirstName=?";
		Employee obj=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setString(1,FirstName);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int empId=rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String address=rs.getString("Address");
				String emailAddress=rs.getString("EmailAddress");
				long phoneNumber=rs.getLong("PhoneNumber");
				LocalDate birthDays=rs.getDate("BirthDays").toLocalDate();
				LocalDate weddingAnniversary=rs.getDate("WeddingAnniversary").toLocalDate();
				obj=new Employee(empId, firstName, lastName, address, emailAddress, phoneNumber, birthDays, weddingAnniversary);
			}
			}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return obj;
	}
	public Employee findByBirthDays(LocalDate birthDay) {
		String sql="select * from Employee where BirthDays=?";
		Employee obj=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setDate(1,Date.valueOf(birthDay));
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int empId=rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String address=rs.getString("Address");
				String emailAddress=rs.getString("EmailAddress");
				long phoneNumber=rs.getLong("PhoneNumber");
				LocalDate birthDays=rs.getDate("BirthDays").toLocalDate();
				LocalDate weddingAnniversary=rs.getDate("WeddingAnniversary").toLocalDate();
				obj=new Employee(empId, firstName, lastName, address, emailAddress, phoneNumber, birthDays, weddingAnniversary);
			}
			}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return obj;
		
	}
	@Override
	public Employee findByWeddingAnniversary(LocalDate weddingAnniversary) {
		String sql="select * from Employee where WeddingAnniversary=?";
		Employee obj=null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setDate(1,Date.valueOf(weddingAnniversary));
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				int empId=rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName=rs.getString("LastName");
				String address=rs.getString("Address");
				String emailAddress=rs.getString("EmailAddress");
				long phoneNumber=rs.getLong("PhoneNumber");
				LocalDate birthDays=rs.getDate("BirthDays").toLocalDate();
				weddingAnniversary=rs.getDate("WeddingAnniversary").toLocalDate();
				obj=new Employee(empId, firstName, lastName, address, emailAddress, phoneNumber, birthDays, weddingAnniversary);
			}
			}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		return obj;
	}
	
	
	
	
}
