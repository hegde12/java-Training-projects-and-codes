package org.app;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeApp
{
    private static final Logger logger = Logger.getLogger(EmployeeApp.class);
    static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) {
        logger.info("main method started");
        int num;
        DBConnection databaseRef = new DBConnection();
        try {
            databaseRef.createTable();  
        }catch (SQLException e){
            logger.error("Database connectivity issue; "+e);
            clickHereToGoFurther();
            return;    
        }

        while (true) {       
            do{          
               listOfOperations();
                try {
                    num = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Just enter a number!!, nothing else");
                    clickHereToGoFurther();
                   
                }
            }while (true);
            
            switch (num) {
                case 1:System.out.println("here you go enter employee details");
                    EmployeeDetails newEmp = EmployeeDetails.createEmployee();
                    databaseRef.addEmployee(newEmp);
                    break;
                case 2: System.out.println("here you go view an employee");
                    System.out.println("Enter employee's first name");
                    String fn = sc.nextLine();
                    System.out.println("Enter employee's last name");
                    try {
                        EmployeeDetails find = databaseRef.showEmployee(fn, sc.nextLine());
                        if (find != null)   
                            System.out.println(find);
                    }catch (NameNotFoundException e){     
                        System.out.println("Sorry, no employee with the given name was found");
                    }
                    break;
                case 3:System.out.println("here you go you can edit emp details");
                    System.out.println("Enter first name ");
                    fn = sc.nextLine();
                    System.out.println("Enter last name");
                    try {
                        EmployeeDetails find = databaseRef.showEmployee(fn,sc.nextLine());
                        if (find==null)   
                            break;
                        else {
                            System.out.println("Do you want to update the address? (y/n)");
                           if(sc.nextLine().equalsIgnoreCase("y")){
                               System.out.println("Enter new address");
                               find.setAddress(sc.nextLine());
                           }
                            System.out.println("Do you want to update the Email ID? (y/n)");
                            if(sc.nextLine().equalsIgnoreCase("y"))
                                find.setEmailID(EmployeeDetails.emailIdValidation());
                            System.out.println("Do you want to update the phone number? (y/n)");
                            if(sc.nextLine().equalsIgnoreCase("y"))
                                find.setPhoneNum(EmployeeDetails.phoneNumberValidation());
                            System.out.println("Do you want to update the Wedding anniversary date (y/n)");
                            if(sc.nextLine().equalsIgnoreCase("y"))
                                find.setmarriageDate(EmployeeDetails.marriageDateValidation());
                            databaseRef.updateEmployee(find);
                        }
                    }catch (NameNotFoundException e) {
                        System.out.println("No employee is found with such details in our table");
                    }
                    break;
                case 4:System.out.println("here you go you can have birt date of whom you want");
                    String bday;
                    do { 
                        System.out.println("enter date Of Birth in DD/MM format");
                        bday = sc.nextLine();
                        try{
                            if(bday.length()!=5)
                                throw new ParseException("invalid date format",0);
                            (new SimpleDateFormat("dd/MM")).parse(bday);
                            break; 
                        }catch (ParseException e){
                            System.out.println("invalid format... Please enter correctly again");
                        }
                    }while (true);
                    List<String[]> birthday = databaseRef.employeesWithGivenDob(bday);
                    if(birthday==null)  
                        break;
                    if(birthday.isEmpty())
                        System.out.println("Couldn't find the match :(");
                    else{
                        Formatter fmt = new Formatter();
                        fmt.format("%22s %15s %34s\n","First Name","Last Name","Email ID");
                        birthday.forEach((emp)->fmt.format("%15s %15s %40s\n",emp[0],emp[1],emp[2]));
                        System.out.print(fmt);
                    }
                    break;
                case 5:System.out.println("here you go you can find employees marriage date");
                    String marriageDay;
                    do {  
                        System.out.println("enter Marriage Date in DD/MM format");
                        marriageDay = sc.nextLine();
                        try{
                            if(marriageDay.length()!=5)
                                throw new ParseException("invalid date format",0);
                            (new SimpleDateFormat("dd/MM")).parse(marriageDay);
                            break; 
                        }catch (ParseException e){
                            System.out.println("invalid format... Please enter correctly again");
                        }
                    }while (true);
                    List<String[]> marriageDateOfEmp = databaseRef.employeesWithGivenMarriageDate(marriageDay);
                    if(marriageDateOfEmp==null)   
                        break;
                    if(marriageDateOfEmp.isEmpty())
                        System.out.println("CouldN't find :(");
                    else{
                        Formatter fmt = new Formatter();
                        fmt.format("%22s %15s %12s\n","First Name","Last Name","Phone no.");
                        marriageDateOfEmp.forEach((emp)->fmt.format("%15s %15s %12s\n",emp[0],emp[1],emp[2]));
                        System.out.print(fmt);
                    }
                    break;
                case 6:System.out.println("here you go View whole employees' data table");
                    List<EmployeeDetails> table = databaseRef.getFullTable();
                    if(table==null) 
                        break;
                    if(table.isEmpty())
                        System.out.println(" employee data not found");
                    else
                        table.stream().sorted(Comparator.comparing(EmployeeDetails::getFirstName)).forEach(System.out::println);//Using java 8 streams
                    break;
                case 7:
                    System.out.println("Tata Bye Bye Good Bye");
                    logger.info("App terminated");
                    return;
                default:
                    System.out.println("Invalid Choice..!!! Please Choose correct option");
            }
            clickHereToGoFurther();
         
        }
    }
    static private void listOfOperations(){
        System.out.println("----------Welcome to My App--------");
        System.out.println("\n\t\t Enter your choice \n\n");
        System.out.println("1. Add new employee into table");
        System.out.println("2. Find an employee details from table");
        System.out.println("3. Update employee details");
        System.out.println("4. Find employees having birthday on a Specified date");
        System.out.println("5. Find employees having wedding anniversary on a Specified date");
        System.out.println("6. View entire table stored by first name in the database");
        System.out.println("7. Exit program");
    }
    static public void clickHereToGoFurther() {
        System.out.println("Press Any button other Than power button to continue...");
        sc.nextLine();
    }
  
}
