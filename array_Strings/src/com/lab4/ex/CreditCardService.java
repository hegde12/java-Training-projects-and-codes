package com.lab4.ex;

public class CreditCardService {
	private CreditCard cardList[];
	private static int maxSize=5;
	private static int cnt=0;
	public CreditCardService() {
		super();
		// TODO Auto-generated constructor stub
		this.cardList=new CreditCard[maxSize];
	}
	public CreditCard[] getCardList() {
		return cardList;
	}
	public void setCardList(CreditCard[] cardList) {
		this.cardList = cardList;
	}
	public boolean addCard(CreditCard card)
	{
		if(cnt<maxSize)
		{
			cardList[cnt]=card;
			cnt++;
			return true;
		}
		else
			return false;
	}
}
