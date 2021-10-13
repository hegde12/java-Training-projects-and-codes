package com.training;
/*Create a Java Class CurrencyConverter
Add a Method inrTousd(double inr) which will return the usd value of inr
Test the Method with a Separate Java Class with main method*/
public class Currency {
	private double inr;
	Currency(double inr)
	{
		this.inr=inr;
	}
	public double getInr()
	{
		return inr;
	}
	public double inrTousd(double inr)
	{
		double usd=inr*70;
		return usd;
	}
}
