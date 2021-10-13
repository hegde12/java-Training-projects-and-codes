package com.lab4.ex;
/*Use the java class credit card created in the project variables_methods
Create a java class CreditCard Service and store all the card details into an array
Create a Java class with main method which gets the array of all the cards and
print all the card details and also the count of all the card Holders whose name
end with "reddy" and count of all card Holders whos name end with "sharma".*/

public class TestLab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCard g=new CreditCard(123,"Gireesh Sharma");
		CreditCard h=new CreditCard(123,"hareesh Sharma");
		CreditCard i=new CreditCard(123,"Gireesh Reddy");
		CreditCard j=new CreditCard(123,"hareesh Reddy");
		CreditCard k=new CreditCard(123,"Gireesh Hegde");
		CreditCardService s=new CreditCardService();
		s.addCard(k);
		s.addCard(j);
		s.addCard(i);
		s.addCard(h);
		s.addCard(g);
		int e=0,d=0;
		CreditCard c[]=s.getCardList();
		for(CreditCard list:c)
		{
			String name=list.getcName();
			if(name.contains("Sharma"))
			{
				e++;
			}
			else if(name.contains("Reddy"))
			{
				d++;
			}
			else
				continue;
			System.out.println(list.getCardNo()+" : "+name);
		}
		System.out.println("Sharma count is : "+e);
		System.out.println("Reddy count is : "+d);
	}

}
