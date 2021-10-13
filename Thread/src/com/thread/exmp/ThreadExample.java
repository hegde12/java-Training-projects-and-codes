package com.thread.exmp;

public class ThreadExample {
	private double balance;

	public synchronized double deposit(double amount) {

	this.balance = this.balance+amount;

	notifyAll();

	return this.balance;

	}

	public synchronized double withdraw(double amount) {

	if(this.balance < amount) {

	System.out.println("Waiting for amount transfer");
	try {
	wait();
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	}

	this.balance = this.balance -amount;

	return this.balance;
	}

}
