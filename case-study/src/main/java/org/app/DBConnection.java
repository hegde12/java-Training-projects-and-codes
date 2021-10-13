package org.app;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private final String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1", user = "hr", pswd = "hr";
    private final Logger logger = Logger.getLogger(DBConnection.class);

    public void addEmployee(EmployeeDetails emp) {
        try(Connection con = DriverManager.getConnection(url,user,pswd)) {
            PreparedStatement pstatement = con.prepareStatement("INSERT INTO employeesDetails values(?,?,?,?,?,?,?)");
            pstatement.setString(1,emp.getFirstName());
            pstatement.setString(2,emp.getLastName());
            pstatement.setString(3,emp.getAddress());
            pstatement.setString(4,emp.getEmailID());
            pstatement.setString(5,emp.getPhoneNum());
            pstatement.setDate(6, new Date(emp.getdateOfBirth().getTime()));  
            if(emp.getmarriageDate()==null)  
                pstatement.setNull(7,Types.NULL);
            else
                pstatement.setDate(7,new Date(emp.getmarriageDate().getTime()));
            System.out.println(pstatement.executeUpdate() + " employee is added :)");
            logger.info(" employee added to the database");
            pstatement.close();
        }catch (SQLException e){
            logger.error("couldn't added the employee to the table");
            System.out.println("Cannot add new employee. We have problem in dataBase :(");
        }
    }

    public EmployeeDetails showEmployee(String firstName, String lastName) throws NameNotFoundException {
        try(Connection con = DriverManager.getConnection(url,user,pswd)){
            PreparedStatement pstatement = con.prepareStatement("SELECT * FROM employeesDetails WHERE UPPER(fname)=? AND UPPER(lname)=?");
            pstatement.setString(1,firstName.toUpperCase());
            pstatement.setString(2,lastName.toUpperCase());
            ResultSet rs = pstatement.executeQuery();
            if(!rs.next()) {
                logger.warn("No employee fetched from the database");
                throw new NameNotFoundException();          
            }
            logger.info("one employee fetched from the database");
            return new EmployeeDetails(rs.getString("fname"),rs.getString("lname"),rs.getString("address"),rs.getString("email"),rs.getString("phone"),rs.getDate("birthday"),rs.getDate("anniversary"));
        }catch (SQLException e){
            logger.error("employee are not selected from table");
            System.out.println("Cannot search employee. Problem in database :(");
            return null;
        }
    }

    public void updateEmployee(EmployeeDetails update){
        try(Connection con = DriverManager.getConnection(url,user,pswd)){
            PreparedStatement pstatement = con.prepareStatement("UPDATE employeesDetails SET address=?, email=?, phone=?, anniversary=? WHERE UPPER(fname)=? AND UPPER(lname)=?");
            pstatement.setString(1,update.getAddress());
            pstatement.setString(2,update.getEmailID());
            pstatement.setString(3,update.getPhoneNum());
            if(update.getmarriageDate()==null)
                pstatement.setNull(4,Types.NULL);
            else
                pstatement.setDate(4,new Date(update.getmarriageDate().getTime()));
            pstatement.setString(5,update.getFirstName().toUpperCase());
            pstatement.setString(6,update.getLastName().toUpperCase());
            if(pstatement.executeUpdate()>=1) {
                logger.info("Update query worked");
                System.out.println("Employee details updated successfully :)");
            }
            else {
                logger.warn("No row affected by the update query");
                System.out.println("Employee details is not updated");
            }
        }catch (SQLException e){
            logger.error("employee can't be updated");
            System.out.println("Cannot update employee. We have problem in dataBase :(");
        }
    }

    public List<String[]> employeesWithGivenDob(String birthDay){
        try(Connection con = DriverManager.getConnection(url,user,pswd)){
            PreparedStatement pstatement = con.prepareStatement("SELECT fname, lname, email FROM employeesDetails WHERE to_char(birthday,'DD/MM')=?");
            pstatement.setString(1,birthDay);
            ResultSet rs = pstatement.executeQuery();
            List<String[]> empList = new ArrayList<>();
            while (rs.next()){
                empList.add(new String[]{rs.getString("fname"), rs.getString("lname"), rs.getString("email")});
            }
            if (empList.isEmpty())
                logger.warn("No one selected same birthday");
            return empList;
        }catch (SQLException e){
            logger.error("Can't Find The details");
            System.out.println("Cannot search employees. Problem in DataBase :(");
            return null;
        }
    }

    public List<String[]> employeesWithGivenMarriageDate(String marriageDay){
        try(Connection con = DriverManager.getConnection(url,user,pswd)){
            PreparedStatement pstatement = con.prepareStatement("SELECT fname, lname, phone FROM employeesDetails WHERE to_char(anniversary,'DD/MM')=?");
            pstatement.setString(1,marriageDay);
            ResultSet rs = pstatement.executeQuery();
            List<String[]> empList = new ArrayList<>();
            while (rs.next())
                empList.add(new String[]{rs.getString("fname"), rs.getString("lname"), rs.getString("phone")});
            if (empList.isEmpty())
                logger.warn("No one selected same MarraiageDay");
            return empList;
        }catch (SQLException e){
            logger.error("Can't find in table");
            System.out.println("Cannot search employees. We have problem in database :(");
            return null;
        }
    }

    public void createTable() throws SQLException {
        try(Connection con = DriverManager.getConnection(url,user,pswd)) {
            Statement st = con.createStatement();
            st.executeUpdate("CREATE TABLE employeesDetails"+
                    " (fname varchar(15), lname varchar(15), address varchar(50),"+
                    " email varchar(30), phone varchar(10), birthday DATE, anniversary DATE)");
            logger.info(" Table is created");
        }catch (SQLSyntaxErrorException e){
            logger.warn("Table already exists");
        }
        catch (SQLException e){
            System.out.println("We got problem in database :(");
            throw e;
        }
    }

    public List<EmployeeDetails> getFullTable(){
        List<EmployeeDetails> table = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,user,pswd)){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employeesDetails");
            while (rs.next())
                table.add(new EmployeeDetails(rs.getString("fname"),rs.getString("lname"),
                        rs.getString("address"),rs.getString("email"),
                        rs.getString("phone"),rs.getDate("birthday"),rs.getDate("anniversary")));
            return table;
        }catch (SQLException e){
            logger.error("Couldn't fetch data from the table");
            System.out.println("Cannot get Employee details. We have problem in Database :(");
            return null;
        }
    }

}
