package com.JDBCEx.ex;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getCon()
	{
		Connection con=null;
		try {
			
			String url="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
			con=DriverManager.getConnection(url,"hr","hr");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
