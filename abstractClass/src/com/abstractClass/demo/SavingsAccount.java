package com.abstractClass.demo;

public class SavingsAccount extends BankAccount {

	private String nominee;
	
	public SavingsAccount(long accountNo,double balence,String nominee) {
		super(accountNo,balence);
		this.nominee = nominee;
	}

	@Override
	public double deposit(double amount) {
		// TODO Auto-generated method stub
		double currentBalence=getBalence();
		double updatedBalance=currentBalence+amount;
		setBalence(updatedBalance);
		return getBalence();
	}

	@Override
	public double withdraw(double amount) {
		// TODO Auto-generated method stub
		double currentBalence=getBalence();
		double updatedBalance=currentBalence;
		if(currentBalence-amount>1000) {
	    updatedBalance=currentBalence-amount;
		setBalence(updatedBalance);
	}
		return getBalence();
		
	}
	public String showGreetings()
	{
		return("Hello "+getNominee());
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

}
