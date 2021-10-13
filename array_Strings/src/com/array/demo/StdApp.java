package com.array.demo;

public class StdApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student ram=new Student("Ram",103);
		Student sham=new Student("Sham",102);
		Student ganesh=new Student("Ganesh",101);
		Student gireesh=new Student("Gireesh",100);
		
		StudentService s=new StudentService();
		s.addStudent(ram);
		s.addStudent(ganesh);
		s.addStudent(sham);
		s.addStudent(gireesh);
		
		Student list[]=s.getStudent();
		for(Student each:list)
		{
			System.out.println(each.getName());
		}

	}

}
