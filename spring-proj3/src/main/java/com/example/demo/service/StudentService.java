package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> findAll() {
		return this.repo.findAll();
	}
	public Student addStudent(Student entity) {
		return this.repo.save(entity);
	}
	public Student findById(Integer key) {
		return this.repo.findById(key).orElseThrow(()-> new RuntimeException("id not found"));
	}
	public List<Student> findByName(String name) {
		
		return this.repo.findByStudentName(name);
	}
	public int updateMark(int rollnumber,double markToUpdate) {
		return this.repo.updateMark(rollnumber, markToUpdate);
	}
	public int remove(int rollnumber) {
		int rowDeleted=0;
		if(this.repo.existsById(rollnumber)) {
			this.repo.deleteById(rollnumber);
			rowDeleted=1;
		}
		return rowDeleted;
	}
	
}
