package com.example.demo;

public class UsingLambda {
	public static void main(String args[])
	{
		Runnable tsk=()->
		{
			for(int i=0;i<5;i++)
			{
				System.out.println(i);
			}
		};
		Thread t=new Thread(tsk);
		t.start();
	}
}
@FunctionalInterface
interface Test
{
	String NAME="Gireesh";
	
	public void test();
}
