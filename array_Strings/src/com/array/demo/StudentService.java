package com.array.demo;

public class StudentService {
	private Student st[];
	private static int maxSize=3;
	private static int cnt=0;
	

	public StudentService(Student[] st) {
		super();
		this.st = new Student[maxSize];
	}

	public StudentService() {
		super();
		this.st=new Student[maxSize];
	}
	
	public boolean addStudent(Student st)
	{
		if(cnt<maxSize) {
		this.st[cnt]=st;
		cnt++;
		return true;
		}
		else
		{
			System.out.println("Array is Full Man");
			return false;
		}
		
	}
	public Student[] getStudent()
	{
		return this.st;
	}

	
}
