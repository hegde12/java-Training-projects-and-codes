package org.app;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class EmployeeDetails {
    private String firstName, lastName, address, emailID, phoneNum;
    private Date dateOfBirth, marriageDate;
    private final static Logger logger = Logger.getLogger(EmployeeDetails.class);

    public EmployeeDetails(){logger.info("One employee object created");}

    public EmployeeDetails(String firstName, String lastName, String address, String emailID, String phoneNum, Date dateOfBirth, Date marriageDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailID = emailID;
        this.phoneNum = phoneNum;
        this.dateOfBirth = dateOfBirth;
        this.marriageDate = marriageDate;
        logger.info("One employee object created");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        logger.info("Address of an Employee is updated");
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
        logger.info("email ID of an Employee is updated");
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        logger.info("Phone number of an Employee is updated");
    }

    public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getmarriageDate() {
        return marriageDate;
    }

    public void setmarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
        logger.info("marriageDate date of an Employee is upadted");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("E, dd MMMM yyyy");
        return "First Name: " + firstName  +
                "; Last Name: " + lastName  +
                "; Address: " + address +
                ";\nEmail ID: " + emailID +
                "; Phone No.: " + phoneNum +
                "; Birthdate: " + ((dateOfBirth==null)?"null":f.format(dateOfBirth)) +
                "; Wedding marriageDate: " + ((marriageDate==null)?"unmarried":f.format(marriageDate)) +
                "\n---------------------------------------------------------------------------------------------------------------------";
    }

    static EmployeeDetails createEmployee(){
        logger.info("creating a new Employee object from user inputs...");
        EmployeeDetails emp = new EmployeeDetails();
        System.out.println("Enter first name ");
        String tmp = EmployeeApp.sc.nextLine();
        emp.setFirstName( tmp.substring(0,1).toUpperCase() + tmp.substring(1) );
        System.out.println("Enter last name ");
        tmp = EmployeeApp.sc.nextLine();
        emp.setLastName(tmp.substring(0,1).toUpperCase() + tmp.substring(1));
        System.out.println("Enter address ");
        emp.setAddress(EmployeeApp.sc.nextLine());

        emp.setEmailID(emailIdValidation());
        emp.setPhoneNum(phoneNumberValidation());
        emp.setdateOfBirth(dateOfBirthValidation());
        emp.setmarriageDate(marriageDateValidation());

        return emp;
    }

    public static String emailIdValidation(){
        final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; 
        String email;
        do {
            System.out.println("Enter email ID ");
            email = EmployeeApp.sc.nextLine();
            if(Pattern.compile(regex).matcher(email).matches())
                return email;
            else
                System.out.println("emailId is not valid...\n");
        }while (true);
    }
    public static String phoneNumberValidation(){
        String phone;
        do {
            System.out.println("Enter phone number ");
            phone = EmployeeApp.sc.nextLine();
            if(Pattern.compile("^[0-9]{10}$").matcher(phone).matches())
                return phone;
            else
                System.out.println("Phone number should only contain  with a total of ten digits...\n");
        }while (true);
    }
    public static Date dateOfBirthValidation(){
        String bday;
        while(true){
            System.out.println("Enter dateOfBirth in DD/MM/YYYY format");
            bday = EmployeeApp.sc.nextLine();
            try {
                Date bDate = new SimpleDateFormat("dd/MM/yyyy").parse(bday);
                if(Integer.parseInt(bday.split("/")[0])>31)
                    throw new ParseException("invalid day",0);
                if(Integer.parseInt(bday.split("/")[1])>12)
                    throw new ParseException("invalid month",3);
                if(Integer.parseInt(bday.split("/")[2])>2021)
                    throw new ParseException("future year not allowed",6);
                return bDate;
            }catch (ParseException e){
                System.out.println(" date entered is not valid...\n");
            }
        }
    }
    public static Date marriageDateValidation(){
        String marriageDate;
        while(true){
            System.out.println("Enter marriageDate  in DD/MM/YYYY format or enter NA if unmarried");
            marriageDate = EmployeeApp.sc.nextLine();
            if(marriageDate.equalsIgnoreCase("NA"))
                return null;
            else
                try {
                    return new SimpleDateFormat("dd/MM/yyyy").parse(marriageDate);
                } catch (ParseException e) {
                    System.out.println(" date entered is not valid...\n");
                }
        }
    }
}
