package com.example.demo;

/*
 @author 
 */

public class CreditCard {
	private long accNo;
	private String accHolderName;
	private static String cardProvider;
	public CreditCard() {
		super();
	}
	public CreditCard(long accNo, String accHolderName) {
		super();
		this.accNo = accNo;
		this.accHolderName = accHolderName;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public static String getCardProvider() {
		return cardProvider;
	}
	public static void setCardProvider(String cardProvider) {
		CreditCard.cardProvider = cardProvider;
	}
	
}
