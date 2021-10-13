package com.jdbc.ex;

import java.util.List;

public interface CrudRepo {
	public boolean add(Student student);
	public List<Student> findAll();
	public int update(Student student);
	public boolean remove(Student student);
	

}
