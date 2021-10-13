package com.abstractClass.demo;

public class TestBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount s=new SavingsAccount(123456789,4000,"Gireesh");
		s.deposit(2000);
		System.out.println(s.getBalence());
		s.withdraw(5500);
		
		System.out.println(s.getBalence());
		BankAccount b=new SavingsAccount(12345432,46789,"Gireesh");
		System.out.println(((SavingsAccount)b).showGreetings());

	}

}
