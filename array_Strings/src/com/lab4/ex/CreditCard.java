package com.lab4.ex;

public class CreditCard {
	private long cardNo;
	private String cName;
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCard(long cardNo, String cName) {
		super();
		this.cardNo = cardNo;
		this.cName = cName;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	

}
