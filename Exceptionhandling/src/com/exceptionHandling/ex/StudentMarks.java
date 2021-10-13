package com.exceptionHandling.ex;

public class StudentMarks {

	private int marks;
	private String name;
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		try {
			if(getMarks()<0 &&getMarks()>100)
			{
				throw new RangeCheckException("Enter proper marks");
			}
			else
				this.marks = marks;
		} catch (RangeCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentMarks(int marks, String name) {
		super();
		try {
			if(getMarks()<0 &&getMarks()>100)
			{
				throw new RangeCheckException("Enter proper marks");
			}
			else
				this.marks = marks;
		} catch (RangeCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.name = name;
	}
	public StudentMarks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[])throws RangeCheckException{
		StudentMarks s=new StudentMarks(120,"hhhs");
		//s.setMarks(110);
		System.out.println(s);
		
		
		
	}
}
