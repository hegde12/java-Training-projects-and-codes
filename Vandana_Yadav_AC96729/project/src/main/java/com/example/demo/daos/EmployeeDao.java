package com.example.demo.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.exception.AnniversaryDoesNotExist;
import com.example.demo.exception.BirthDateDoesNotExist;
import com.example.demo.exception.EmployeeDoesNotExist;
import com.example.demo.exception.NameDoesNotExist;
import com.example.demo.exception.TableEmpty;
import com.example.demo.ifaces.CrudRepository;
import java.sql.Date;
import java.sql.DriverManager;

public class EmployeeDao implements CrudRepository {
	
	
	private Connection con ;
	
	
	public EmployeeDao(Connection con) {
		super();
		this.con = con;
	}
	
	

	@Override
	public boolean add(Employee t) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values(?,?,?,?,?,?,?,?)";
		int rowAdded=0;
		
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1,t.getId());
			pstmt.setString(2,t.getFirstName());
			pstmt.setString(3,t.getLastName());
			pstmt.setString(4,t.getAddress());
			pstmt.setString(5,t.getEmailAddress());
			pstmt.setString(6,t.getPhoneNumber());
			pstmt.setDate(7,Date.valueOf(t.getBirthDate()));
			pstmt.setDate(8,Date.valueOf(t.getWeddingAnniversary()));
			rowAdded = pstmt.executeUpdate();
		}catch(SQLException  e) {
			System.out.println(e.getMessage());
		}
		return  rowAdded==1?true:false;
	
	}

	@Override
	public List<Employee> findAll() throws TableEmpty {
		// TODO Auto-generated method stub
		 List<Employee> list=new ArrayList<>();
	        String sql = "select * from employee";

	        try(PreparedStatement pstmt = con.prepareStatement(sql)){
	            ResultSet rs = pstmt.executeQuery();

	            while(rs.next()) {
	            	int id = rs.getInt(1);

	                String firstName = rs.getString(2);
	                String lastName = rs.getString(3);
	                String address = rs.getString(4);
	                String emailAddress = rs.getString(5);
	                String phoneNumber = rs.getString(6);
	                LocalDate birthDay = rs.getDate(7).toLocalDate();
	                LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();

	                list.add(new Employee(id, firstName, lastName, address, emailAddress, weddingAnniversary, phoneNumber, birthDay));
	            }
	        }
	        catch(SQLException  e) {
	            e.printStackTrace();
	        }
	        
	        if(list.size()==0) {
				throw new TableEmpty("Employee Table is Empty ");
			}
	        return list;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) throws NameDoesNotExist {
		// TODO Auto-generated method stub
		
		List<Employee> list= new ArrayList<>();
        String sql="select * from employee where firstname= ?";
        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int id= rs.getInt(1);
                String firstName= rs.getString(2);
                String lastName= rs.getString(3);
                String address= rs.getString(4);
                String emailAddress= rs.getString(5);
                LocalDate weddingAnniversary= rs.getDate(8).toLocalDate();
                String phoneNumber= rs.getString(6);
                LocalDate birthDate= rs.getDate(7).toLocalDate();
                
                list.add(new Employee(id, firstName, lastName, address, emailAddress, weddingAnniversary, phoneNumber, birthDate));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(list.size()==0) {
			throw new NameDoesNotExist("Employee DoesNot Exsist With name "+name);
		}
        return list;
		
	}

	@Override
	public int update(Employee t) {
		// TODO Auto-generated method stub
		int res=0;
		String sql = "update employee set firstName=?,lastName=?,address=?,email=?,phoneNumber=?,dateOfBirth=?,weddingAnniversary=? where Id = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1,t.getFirstName());
			pstmt.setString(2,t.getLastName());
			pstmt.setString(3,t.getAddress());
			pstmt.setString(4,t.getEmailAddress());
			pstmt.setString(5,t.getPhoneNumber());
			pstmt.setDate(6,Date.valueOf(t.getBirthDate()));
			pstmt.setDate(7,Date.valueOf(t.getWeddingAnniversary()));
			pstmt.setInt(8, t.getId());
			res = pstmt.executeUpdate();
			} catch(Exception ex) {
			    ex.printStackTrace();
		    }
		return res>0?1:0;
	}

	
	@Override
	public Employee findById(int e) throws EmployeeDoesNotExist {
		// TODO Auto-generated method stub
		
       Employee employee = null;
		
		String sql = "select * from employee where id = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1,e);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
			   String firstName = rs.getString(2);
			   String lastName = rs.getString(3);
			   String address = rs.getString(4);
			   String emailAddress = rs.getString(5);
			   String phoneNumber = rs.getString(6);
			   LocalDate birthDay = rs.getDate(7).toLocalDate();
			   LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
			   employee= new Employee(e, firstName, lastName, address, emailAddress, weddingAnniversary, phoneNumber, birthDay);
			}
		}
		catch(SQLException  x) {
			x.printStackTrace();
		}
		if(employee==null) {
			throw new EmployeeDoesNotExist("Employee DoesNot Exsist With Id "+e);
		}
		
		return employee;
	
	}

	@Override
	public List<Employee> getEmployeeByBirthDate(LocalDate date) throws BirthDateDoesNotExist {
		// TODO Auto-generated method stub
		List<Employee> list=new ArrayList<>();
		String sql = "select * from employee where dateOfBirth = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setDate(1, Date.valueOf(date));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String emailAddress = rs.getString(5);
				String phoneNumber = rs.getString(6);
				LocalDate birthDate = rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
				
				list.add(new Employee(id, firstName, lastName, address, emailAddress, weddingAnniversary, phoneNumber, birthDate));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(list.size()==0) {
			throw new BirthDateDoesNotExist("Employee Does Not Exsist With This BirthDate "+date);
		}
		return list;
	}

	@Override
	public List<Employee> getEmployeeByAnniversary(LocalDate date) throws AnniversaryDoesNotExist {
		// TODO Auto-generated method stub
		List<Employee> list=new ArrayList<>();
		String sql = "select * from employee where weddingAnniversary = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setDate(1, Date.valueOf(date));
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String address = rs.getString(4);
				String emailAddress = rs.getString(5);
				String phoneNumber = rs.getString(6);
				LocalDate birthDate = rs.getDate(7).toLocalDate();
				LocalDate weddingAnniversary = rs.getDate(8).toLocalDate();
				
				list.add(new Employee(id, firstName, lastName, address, emailAddress, weddingAnniversary, phoneNumber, birthDate));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(list.size()==0) {
			throw new AnniversaryDoesNotExist("Employee Does Not Exsist With This Anniversary "+date);
		}
		return list;
		
	}

	@Override
	public boolean remove(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		 String sql = "delete from employee where id = ? ";
		 int rowDeleted=0;
	     try(PreparedStatement psmt = con.prepareStatement(sql)){
				
				psmt.setInt(1, id);
				rowDeleted=psmt.executeUpdate();
	      }catch (SQLException e) {
		   e.printStackTrace();
		}
			
	      return (rowDeleted>=1)?true:false;
	}



	@Override
	public void createTable() {
		
		  try{
	            Statement st = con.createStatement();
	            st.executeUpdate("create table employee(id number primary key,firstName varchar2(20),lastName varchar2(20),address varchar2(20),email varchar2(20),phoneNumber number ,dateOfBirth date , weddingAnniversary date)");
	           
	        }catch (SQLSyntaxErrorException e){
	            e.printStackTrace();
	        }
	        catch (SQLException e){
	            System.out.println("Database problem ");
	           
	        }
		  
	
	}

	
	

	
	

}
