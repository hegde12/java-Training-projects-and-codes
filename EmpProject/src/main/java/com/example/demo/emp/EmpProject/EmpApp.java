package com.example.demo.emp.EmpProject;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		
		
		try
		{
			con = EmployeeHelper.getConnection();
			if(con!=null)
			{
				System.out.println("Success");
				while(choice!=4)
				{
					System.out.println("Enter your choice");
					System.out.println("press 1 for insert ");
					System.out.println("press 2 for update ");
					System.out.println("press 3 for delete ");
					System.out.println("press 4 for exit ");
					choice=scanner.nextInt();
					switch(choice)
					{
					case 1:
						new EmployeeUtil().insertIntoEmp();
					}

				}
			}
			

	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
