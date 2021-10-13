package com.jdbc.ex;

import java.sql.Connection;
import java.time.LocalDate;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=DbCon.getCon();
		CrudRepo r=new StudentImpl(con);
		Student S=new Student(111,"Gireesh",LocalDate.of(2000, 02, 16),88);
		r.add(S);

	}

}
