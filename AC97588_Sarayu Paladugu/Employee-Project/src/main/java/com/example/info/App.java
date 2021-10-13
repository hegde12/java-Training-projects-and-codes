package com.example.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.example.employee.*;
import com.example.stmt.*;



public class App 
{
    public static void main( String[] args )
    {
    	Logger log=Logger.getRootLogger();
    	Connection con=DbConnection.getOracleConnection();
		Repository<Employee, Integer, String, java.sql.Date> repo=new EmployeeService(con);
		System.out.println(DbConnection.getOracleConnection());
		try(Scanner sc=new Scanner(System.in);) {
        	log.debug("Inside the block");
        	System.out.println("-------------------------\n 1.INSERT DATA\n 2.RETRIEVE DATA\n "
        			+ "3.RETRIEVE DATA USING FIRSTNAME(SELECT)\n 4.EDIT THE ROW IN A TABLE(UPDATE)\n "
        			+ "5.RETRIEVE DATA WITH GIVEN BIRTHDAY\n 6.RETRIEVE DATA WITH GIVEN WEDDING DATE\n "
        			+ "7.RETRIEVE FIRSTNAME AND PHONE NUMBER(SELECT)\n 8.RETRIEVE DATA WITH EMPID(SELECT)\n "
        			+ "9.DELETE A ROW FROM TABLE\n 10.DELETE ALL RECORDS FROM TABLE\n");
        	lp:while(true) {
        	log.info("Enter the number ");
        	int key=sc.nextInt();
            log.info("entered key := "+key);
            switch(key) {
            case 1:
			Employee ramesh=new Employee(1001,"ramesh","mariyala","Hyderabad","ramesh@gmail.com",9787767660L,LocalDate.of(1995, 7, 12),LocalDate.of(2012, 9, 10));
			Employee sony=new Employee(1002,"sony","ganji","Hyderabad","sony@gmail.com",9781566660L,LocalDate.of(1996, 5, 11),LocalDate.of(2013, 10, 10));
			Employee sujana=new Employee(1003,"sujana","veyuru","Warangal","sujana@gmail.com",9564367660L,LocalDate.of(1994, 3, 9),LocalDate.of(2013, 2, 4));
			repo.add(ramesh);					
			repo.add(sony);
			repo.add(sujana);
			Employee swathi=new Employee(1004,"swathi","cheryala","Warangal","swathi@gmail.com",9564676760L,LocalDate.of(1995, 3, 9),LocalDate.of(2014, 2, 4));
			repo.add(swathi);
			log.info("Employee details are added");
			break;
            case 2:
			List<Employee> list=repo.findAll();
			for(Employee eachEmployee:list) {
				log.info(eachEmployee);
			}
			break;
            case 3:
            	log.info("Enter fisrtname of any employee : ");
               	String FirstName=sc.next();
               	Employee emp=repo.findByFirstName(FirstName);
               	log.info(emp);
               	break;
            case 4:
            	Employee ramesh1=new Employee(1001,"ramesh","mariyala","Chennai","ramesh@gmail.com",9787767660L,LocalDate.of(1995, 7, 12),LocalDate.of(2012, 9, 10));
                int c=repo.Update(ramesh1);
                if(c>0) {
               		log.info("Row updated");
                }
               	else {
               		log.info("Not Updated");
                }
        		break;
            case 5:
            	LocalDate BirthDays=LocalDate.of(1995,3, 9);
               	emp=repo.findByBirthDays(BirthDays);
               	log.info(emp);
               	break;
            case 6:
            	LocalDate WeddingAnniversary=LocalDate.of(2013,10, 10);
           	   	emp=repo.findByWeddingAnniversary(WeddingAnniversary);
           	   	log.info(emp);
           	   	break; 
            case 7:
            	list=repo.findFNPN();
    			for(Employee eachEmployee:list) {
    				log.info(eachEmployee);
    			}
    			break;
            case 8:
            log.info("Enter Employee Id");
            int EmpId=sc.nextInt();
			Employee emp1=repo.findById(EmpId);
			log.info(emp1);
			break;
            case 9:
			swathi=new Employee(1004,"swathi","cheryala","Warangal","swathi@gmail.com",9564676760L,LocalDate.of(1995, 3, 9),LocalDate.of(2014, 2, 4));
			repo.remove(swathi);
			log.info("one row deleted");
			break;
            case 10:
            String sql="delete from Employee";
            try(PreparedStatement stmt=con.prepareStatement(sql)) {
            int deletedRows=stmt.executeUpdate(sql);
            if(deletedRows>0) {
            	log.info("Data is Deleted from table");
            }
            else {
            	log.info("Not Deleted from table");
            }
            }
            catch(SQLException e) {
            	e.printStackTrace();
        	}
            break;
            case 11:
            break lp;
			default:
			log.info("end");
            }
        }
	} 
        catch(Exception e) {
        	log.debug(e.getMessage());
        	e.printStackTrace();
        }
    }
}
