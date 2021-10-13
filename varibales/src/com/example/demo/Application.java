package com.example.demo;

public class Application {
	
	public static void print(CreditCard c) {
	System.out.println(c.getAccHolderName());
	System.out.println(c.getAccNo());
	System.out.println(CreditCard.getCardProvider());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCard c=new CreditCard(100,"Gireesh");
		print(c);
	}

}
