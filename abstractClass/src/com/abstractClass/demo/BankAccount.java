package com.abstractClass.demo;

/*1) Create a Abstract class Bank Account



2) Create Subclasses -Savings Account,Company Account extending Bank Account



3) Override the methods of the abstract class



4) Create a Application class with main method and test



=================================================



1. Add a non abstract method in Bank Account



2. Don't override the method in sub class



3. Try to access the method with superclass object reference



==========================================================



1. Add a non abstract method in Sub Class of Bank Account



2. Try to access the method with superclass object reference*/

public abstract class BankAccount {
	private long accountNumber;
	private double balence;

	public BankAccount(long accountNo, double balence) {
		// TODO Auto-generated constructor stub
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalence() {
		return balence;
	}
	public void setBalence(double balence) {
		this.balence = balence;
	}
	public abstract double deposit(double amount);
	public abstract double withdraw(double amount);
	
}
