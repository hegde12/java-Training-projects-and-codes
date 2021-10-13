package com.example.demo.emp.EmpProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeHelper {
	public static void close(ResultSet results) {
		try
		{
			if(results!=null)
			{
				results.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}
	public static void close(Connection con) {
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}
	public static void close(PreparedStatement st) {
		try
		{
			if(st!=null)
			{
				st.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection()
	{
		try
		{
			//Class.forName(DbConnectin.DRIVER);
           Connection con = DriverManager.getConnection(DbConnectin.URL,DbConnectin.USERNAME,DbConnectin.PASSWORD);
           System.out.println(con);
           return con;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
