package com.training;
/*Create a Java Class Employee
Add the Attributes like employeeId,employeeName,salary
Provide 2 constructors- Zero Argument and paramerized
Provide Set/Get Methods
If the salary is less than 5000 it should print a invalid value message
Test the Constructors and Methods with separate java class having a main method*/

public class TestEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e=new Employee(123,4000,"Gireesh");
		e.checkSal();
		e.setEmpid(123);
		e.setEname("Gireesh");
		e.setSalary(6789);
		System.out.println(e.getEmpid());
		System.out.println(e.getEname());
		System.out.println(e.getSalary());
		e.checkSal();
	}

}
class Employee
{
	private int empid,salary;
	private String ename;
 
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid, int salary, String ename) {
		super();
		this.empid = empid;
		this.salary = salary;
		this.ename = ename;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	void checkSal() {
	if(salary<5000)
	{
		System.out.println("Invalid salary");
	}
	else
	{
		System.out.println("Valid");
	}
	}
}