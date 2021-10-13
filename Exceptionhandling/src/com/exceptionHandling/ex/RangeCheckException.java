package com.exceptionHandling.ex;

public class RangeCheckException extends Exception{
	private String messege;

	public RangeCheckException(String messege) {
		super(messege);
		this.messege=messege;
	}
	public String getMessege()
	{
		return "Exception : " +messege;
	}
		
}
