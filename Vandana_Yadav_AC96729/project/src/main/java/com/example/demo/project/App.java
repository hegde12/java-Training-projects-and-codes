package com.example.demo.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import org.apache.log4j.Logger;

import com.example.demo.entity.Employee;
import com.example.demo.exception.AnniversaryDoesNotExist;
import com.example.demo.exception.BirthDateDoesNotExist;
import com.example.demo.exception.EmployeeDoesNotExist;
import com.example.demo.exception.NameDoesNotExist;
import com.example.demo.exception.TableEmpty;
import com.example.demo.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main( String[] args ) throws AnniversaryDoesNotExist, BirthDateDoesNotExist, TableEmpty {
     Logger log=Logger.getRootLogger();
     log.info("*************LOG STARTED**********");

	
	Scanner sc = new Scanner(System.in);
    EmployeeService service = new EmployeeService();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
    int casee =0;
    boolean status =true;
    service.createTable();
    int id=0;
    String firstName=null;
    String lastName=null;
    String address=null;
    String email=null;
    String phoneNumber=null;
    LocalDate birthday = null;
    LocalDate weddingAnniversary = null;
    List<Employee> list= null;
    List<String> list2 =null;
    LocalDate date=null;
    
    System.out.println("Press \n 1 to add new Employee \n "
			+ "2 to get all employee details  \n"
			+ " 3 to get employee details by id \n "
			+ "4 to get employee details by id weddingAnniversary \n "
			+ "5 to get employee details by birthDate \n"
			+ " 6 to update the employee details \n"
			+ " 7 to get employee details by first name \n"
			+  " 8 to delete employee by id\n"
			+" 9 to display options again");
  
    while(true) {
    	


    	casee = sc.nextInt();
   
    	switch(casee) {
    	
    	
    		case 1:	
			try {
				System.out.println("Type the id of employee ");
				id=sc.nextInt();
				System.out.println("Type the First Name of employee ");
				firstName=sc.next();
				System.out.println("Type the Last Name  of employee ");
				lastName = sc.next();
				System.out.println("Type the Address  of employee ");
				address = sc.next();
				System.out.println("Type the Email  of employee ");
				email = sc.next();
				System.out.println("Type the Phone Number  of employee ");
				phoneNumber = sc.next();
				if(phoneNumber.length()<8) {
					log.error("PhoneNumber cant be less then 8 digits");
					System.out.println("Please press again from [1-9] for next case");
					break;
				}
				System.out.println("Type the Birth Date  of employee , format = DD-MM-YYYY ");
				try {
					birthday = LocalDate.parse(sc.next(), formatter);
				} catch (Exception e1) {
					 log.error("Wrong Format ");
					 System.out.println("Please press again from [1-9] for next case");
					 continue;
				}
				System.out.println("Type the Wedding Anniversary of employee , format = DD-MM-YYYY");
				try {
					weddingAnniversary = LocalDate.parse(sc.next(),formatter);
				} catch (Exception e1) {
					log.error("Wrong Format ");
					System.out.println("Please press again from [1-9] for next case");
					break;
				}
			} catch (Exception e1) {
				log.error("wrong input given");
				System.out.println("Please press again from [1-9] for next case");
				break;
			}
    				boolean result = service.add(new Employee(id, firstName, lastName, address, email, weddingAnniversary, phoneNumber, birthday));
    			    if(result)
    				{log.info("Employee Added Successfully");
    				System.out.println("Please press again from [1-9] for next case");
    				}
    				else{
    					log.error("Failed to create new Employee");
    					System.out.println("Please press again from [1-9] for next case");
    				}
    				break;
    				
    				
    				
    		case 2:
			try {
				list2 = service.findAll();
			} catch (TableEmpty e2) {
				log.error("No Data in the DataBase");
				System.out.println("Please press again from [1-9] for next case");
				break;
			}
    	        	  log.info("Fetching Details Of All Employee");
    	              list2.forEach((e)->System.out.println("DATA : "+e));
    	              log.info("Employee Details Fetched Sucessfully");
    	              System.out.println("Please press again from [1-9] for next case");
    	              break;
    	
    		
    			
    			
    	              
    			
    			
    		case 3:
    			System.out.println("Enter the id of employee");
    		    id=sc.nextInt();
    	     	log.info("Fetching Details Of Employee By id " +id);
    		    Employee employee = null;
    		    try {
                    employee= service.findById(id);
                } catch (EmployeeDoesNotExist e) {
                   log.error("No data found for the given employee id ");
                   System.out.println("Please press again from [1-9] for next case");
                   break;
                }
			    System.out.println("DATA : "+employee);
			    log.info("Employee details fetched sucessfully");
			    System.out.println("Please press again from [1-9] for next case");
                break;
                
                
                
             
    		case 4:
    			System.out.println("enter employee Wedding Anniversary");
  	          try {
  	            date = LocalDate.parse(sc.next(), formatter);
  	          }catch(DateTimeParseException e) {
  	        	log.error("Wrong Format ");
  	        	System.out.println("Please press again from [1-9] for next case");
				break;
  	          }
  	          log.info("Fetching employee details by wedding Anniversary = "+date );
  	          try {
				list2 = service.getEmployeeByAnniversary(date);
			} catch (AnniversaryDoesNotExist e) {
				log.error("No records present for the given date ");
				System.out.println("Please press again from [1-9] for next case");
				break;
			}
  	          list2.forEach((e)->System.out.println("DATA : "+ e));
  	          log.info("Employee Details Fetched Sucessfully");
  	        System.out.println("Please press again from [1-9] for next case");
  	          break;
    			
	            
	            
  
    	case 5:
    		System.out.println("Enter employee Birth Date");
		      try {
		        date = LocalDate.parse(sc.next(), formatter);
		      } catch(DateTimeParseException e) {
		    	  log.error("Wrong Format");
		    	  System.out.println("Please press again from [1-9] for next case");
	  		        break;
		      }
		      log.info("Fetching employee details by birth date = "+date);
		      try {
				list2= service.getEmployeeByBirthDate(date);
			} catch (BirthDateDoesNotExist e1) {
				log.error("No records present for the given date ");
				System.out.println("Please press again from [1-9] for next case");
				break;
			}
		      list2.forEach((e)->System.out.println("DATA : "+ e));
		      log.info("Employee Details Fetched Sucessfully ");
		      System.out.println("Please press again from [1-9] for next case");
		      break;
		      
		      
    	
          case 6: 
	          try {
				System.out.println("Enter id of employee you want to edit");
				    id = sc.nextInt();
				    log.info("Updating Employee Detalis with id = "+id);
				   try {
				       employee = service.findById(id);
				   } catch(EmployeeDoesNotExist e) {
				    log.error("No Data present for the given employee id ");
				    System.out.println("Please press again from [1-9] for next case");
				    break;
				  }
				   System.out.println("Type the new id of employee ");
					id=sc.nextInt();
					System.out.println("Type the new First Name of employee ");
					firstName=sc.next();
					System.out.println("Type the new Last Name  of employee ");
					lastName = sc.next();
					System.out.println("Type the new Address  of employee ");
					address = sc.next();
					System.out.println("Type the new Email  of employee ");
					email = sc.next();
					System.out.println("Type the new Phone Number  of employee ");
					phoneNumber = sc.next();
					if(phoneNumber.length()<8) {
						log.error("PhoneNumber cant be less then 8 digits");
						System.out.println("Please press again from [1-9] for next case");
						break;
					}
					System.out.println("Type the new Birth Date  of employee , format = DD-MM-YYYY ");
					try {
						birthday = LocalDate.parse(sc.next(), formatter);
					} catch (Exception e1) {
						 log.error("Wrong Format ");
						 System.out.println("Please press again from [1-9] for next case");
						 continue;
					}
					System.out.println("Type the new Wedding Anniversary of employee , format = DD-MM-YYYY");
					try {
						weddingAnniversary = LocalDate.parse(sc.next(),formatter);
					} catch (Exception e1) {
						log.error("Wrong Format ");
						System.out.println("Please press again from [1-9] for next case");
						break;
					}
			} catch (Exception e1) {
				log.error("wrong input given");
				System.out.println("Please press again from [1-9] for next case");
				break;
			}
			    int res= service.update(new Employee(id, firstName, lastName, address, email, weddingAnniversary, phoneNumber, birthday));
	            if(res==1) {
		        log.info("Employee Details Updated");
		        System.out.println("Please press again from [1-9] for next case");
	            }else {
		        log.info("Failed to Update Employee Details");
		        System.out.println("Please press again from [1-9] for next case");
	            }
	            break;
	          
	          
	          
          case 7:
        	  System.out.println("Enter the First Name of the employee");
		        firstName= sc.next();
		        log.info("Finding Employee Details By First Name = "+firstName);
		        try {
		        	list =service.getEmployeeByName(firstName);
				} catch (NameDoesNotExist e) {
					log.error("No data found for the given FirstName ");
					System.out.println("Please press again from [1-9] for next case");
				    break;
				}
		        list.forEach((e)->System.out.println("DATA:" +e));
		        log.info("Employee details Fetched Sucessfully");
		        System.out.println("Please press again from [1-9] for next case");
		        break;
              
              
              
          case 8:
        	    System.out.println("Enter id of employee");
	            id = sc.nextInt();
	            log.info("Deleting Employee with id = "+id);
        	    boolean deleted = service.DeleteEmployee(id);
        	    if(deleted==true) {
        	    	log.info("Employee Deleted Successfully");
        	    	System.out.println("Please press again from [1-9] for next case");
        	    }else {
                    log.error("Failed to delete employee");
                    System.out.println("Please press again from [1-9] for next case");
        	    }
        	    break;
        	    
          case 9:
        	  System.out.println("Press \n 1 to add new Employee \n "
        				+ "2 to get all employee details  \n"
        				+ " 3 to get employee details by id \n "
        				+ "4 to get employee details by id weddingAnniversary \n "
        				+ "5 to get employee details by birthDate \n"
        				+ " 6 to update the employee details \n"
        				+ " 7 to get employee details by first name \n"
        				+  " 8 to delete employee by id\n"
        				+" 9 to display options again");
        	  break;
        
        	 

              
          default:
        	  break;
              
              
         
	 
        } 


		 
          }	
  
    }

}
