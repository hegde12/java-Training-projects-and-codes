package com.example.rest_service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(value="sudent")
public class StudentService {
	@GET
	public String giveName()
	{
		return "Ram Shyam";
	}
	@GET
	@Path("/{id}")
	public Response findStudentById(@PathParam("id")int id)
	{
		Student obj=new Student(101,"Gireesh",100);
		if(id==2)
		{
			obj=new Student(102,"Gnana",100);
		}
		return Response.ok().entity(obj).build();
	}
	@POST
	@Produces(value=MediaType.APPLICATION_JSON)
	@Consumes(value=MediaType.APPLICATION_JSON)
	
	public Response addStudent(Student obj) {
		System.out.println(obj +"added");
		return Response.status(201).entity(obj).build();
		}
	

}
