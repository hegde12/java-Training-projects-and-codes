package com.exceptionHandling.ex;
import java.util.*;
import java.lang.*;

public class CheckException {
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in);){
		CheckException c=new CheckException();
		c.usingClssCastException();
		CheckMultipleExp b=new CheckMultipleExp();
		int n=sc.nextInt();
		b.tryWithMultipleCatch(n);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void usingClssCastException() {
		Object age=Integer.valueOf(20);
		try {
			Integer n=(Integer) age;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("object should be number");
			e.printStackTrace();
		}
		System.out.println(age);
	}

}
class CheckMultipleExp{
	public void tryWithMultipleCatch(int n) {
		try {
			int num=20;
			int [] denom= {10,0};
			System.out.println(num/n);
		} catch ( ArithmeticException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.err.println(e+ "  Its exception");
			e.printStackTrace();
		}
		finally {
			System.out.println("Finally im here");
		}
	}
}
