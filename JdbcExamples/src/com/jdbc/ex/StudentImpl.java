package com.jdbc.ex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class StudentImpl implements CrudRepo {
	private Connection con;
	public StudentImpl(Connection con) {
		super();
		this.con = con;
	}
	int row=0;
	//Student t=new Student(rollNo,name,dob,marks);
	@Override
	public boolean add(Student t) {
		// TODO Auto-generated method stub
		String st="insert into student values(?,?,?,?)";
		try (PreparedStatement ps=con.prepareStatement(st)){
			ps.setInt(1, t.getRollNo());
			ps.setString(2, t.getName());
			ps.setDate(3, Date.valueOf(t.getDob()));
			ps.setInt(4, (int) t.getMarks());
			// ps.executeQuery();
			int r=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public List <Student>findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
