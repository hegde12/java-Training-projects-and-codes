package com.example.demo.ifaces;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.exception.AnniversaryDoesNotExist;
import com.example.demo.exception.BirthDateDoesNotExist;
import com.example.demo.exception.EmployeeDoesNotExist;
import com.example.demo.exception.NameDoesNotExist;
import com.example.demo.exception.TableEmpty;

public interface CrudRepository {

	public void createTable();
	public boolean add(Employee t);//create
	public List<Employee> findAll() throws TableEmpty;//read
	 List<Employee> getEmployeeByName(String name) throws NameDoesNotExist;
	public int update(Employee t);//update
	public boolean remove(Employee t);//delete
	public Employee findById(int e) throws EmployeeDoesNotExist;
	public List<Employee> getEmployeeByBirthDate(LocalDate date) throws BirthDateDoesNotExist;
	public List<Employee> getEmployeeByAnniversary(LocalDate date) throws AnniversaryDoesNotExist;
	boolean remove(int id);
	
	
	// boolean addEmployee(Employee employee);
	  //  List<Employee> getEmployee(String name) throws NameNotFoundException;
	//    Employee getEmployeeByID(int id) throws EmployeeNotFoundException ;
	   // boolean editEmployee(Employee employee);
	   // List<Employee> getEmployeeOfGivenBirthDate(LocalDate date);
	//    List<Employee> getEmployeeOfGivenAnniversary(LocalDate date);
	//    List<Employee> getAllEmployees();

	
}
