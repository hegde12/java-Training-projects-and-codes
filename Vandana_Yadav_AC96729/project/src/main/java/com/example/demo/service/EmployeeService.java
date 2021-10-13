package com.example.demo.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


import com.example.demo.daos.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.exception.AnniversaryDoesNotExist;
import com.example.demo.exception.BirthDateDoesNotExist;
import com.example.demo.exception.EmployeeDoesNotExist;
import com.example.demo.exception.NameDoesNotExist;
import com.example.demo.exception.TableEmpty;
import com.example.demo.ifaces.CrudRepository;
import com.example.demo.utils.DbConnection;
import java.util.List;

public class EmployeeService {
	
	Connection con = null;
	CrudRepository repo;
	
   
    public EmployeeService(){
    	con=DbConnection.getOracleConnection();
    	repo=new EmployeeDao(con);
    }
    
    public void createTable() {
    	repo.createTable();
    }
    public boolean add(Employee employee) {
    	return repo.add(employee);
    }
    
    public List<String> findAll() throws TableEmpty{
		List<Employee> list=repo.findAll();
		return list.stream().map(e->("FirstName = "+e.getFirstName()+", PhoneNumber = "+e.getPhoneNumber())).collect(Collectors.toList());
		
    }
    
    public List<String> getEmployeeByBirthDate(LocalDate date) throws BirthDateDoesNotExist{
		List<Employee> list = repo.getEmployeeByBirthDate(date);
		return list.stream().map(e->("First name = "+e.getFirstName() +" , Email Address = "+ e.getEmailAddress())).collect(Collectors.toList());
	}
    
    
    public List<Employee> getEmployeeByName(String name) throws NameDoesNotExist{
        return repo.getEmployeeByName(name);
    }
    
    public int update(Employee employee) {
		return repo.update(employee);
	}
    
    public Employee findById(int id) throws EmployeeDoesNotExist {
        return repo.findById(id);
    }
   
    public List<String> getEmployeeByAnniversary(LocalDate date) throws AnniversaryDoesNotExist {
		List<Employee> list = repo.getEmployeeByAnniversary(date);
		return list.stream().map(e -> ("First name = "+e.getFirstName()+" , Phone Number = "+e.getPhoneNumber())).collect(Collectors.toList());
    }
    
    public boolean DeleteEmployee(int id) {
    	return repo.remove(id);
    }
   

}
