package com.example.stmt;

import java.time.LocalDate;
import java.util.List;


public interface Repository<T,E,S,D> {

	//add details
	public boolean add(T t);
	//select
	public List<T> findAll();
	//find by firstname
	public T findByFirstName(S s);
	//update 
	public int Update(T t);
	//find by birthday
	public T findByBirthDays(LocalDate birthDays);
	// find by wedding date
	public T findByWeddingAnniversary(LocalDate weddingAnniversary);
	//select firstname,phonenumber
	public List<T> findFNPN();
	//find by empid
	public T findById(E e);
	//delete
	public boolean remove(T t);
}
