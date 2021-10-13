package com.example.demo.contollers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
@RequestMapping(path = "/api/v1/students")
@RestController
public class StudentContoller {

	private StudentService service;

	@Autowired
	public void setService(StudentService service) {
		this.service = service;
	}
	//url mapping is prefixed with /api/ followed by version number / followed
	//entity class name is plural and lowercase
	
	@GetMapping 
	//(path = "/api/v1/students")
	@RolesAllowed(value= {"ROLE_ADMIN"})
	public List<Student> findAll() {
		
		return this.service.findAll();
		
	}
	@GetMapping(path = "/{rollnumber}")
	@RolesAllowed(value= {"ROLE_ADMIN","ROLE_GUEST"})
	public Student findById(@PathVariable("rollnumber")int rollnumber ) {
		
		return this.service.findById(rollnumber);
		
	}
	@GetMapping(path = "/srch/{name}")
	public List<Student> findByName(@PathVariable("name")String studentname) {
		
		return this.service.findByName(studentname);
		
	}
	@PutMapping(path = "/{rollnumber}/{markToUpdate}")
	public ResponseEntity<String> updateMark(@PathVariable("rollnumber")int rollnumber,@PathVariable("markToUpdate")double markToUpdate ) {
		
		int count= this.service.updateMark(rollnumber, markToUpdate);
		return ResponseEntity.ok().body(count+"=Records updated");
		
	}
	@DeleteMapping(path="/{rollnumber}")
public ResponseEntity<String> removeStudent(@PathVariable("rollnumber")int rollnumber) {
		
		int count= this.service.remove(rollnumber);
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message="Record Not Found";
		if(count==1) {
			status=HttpStatus.OK;
			message="one record deleted";
			//return ResponseEntity.ok().body(count+"=records deleted"); 
		}
//		else {
		return ResponseEntity.status(status).body(message);
		
//	}
	}
	
	//@PostMapping     //(path = "/api/v1/students")
//	public Student add(@RequestBody Student entity) {
//		return this.service.addStudent(entity);
//	}
	@PostMapping     //(path = "/api/v1/students")
	public ResponseEntity<Student> add(@RequestBody Student entity) {
		Student addedEntity=this.service.addStudent(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
}
