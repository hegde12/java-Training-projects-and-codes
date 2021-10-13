package com.lab3.ex;
import java.util.Scanner;
/*
 *  Create a Java Class Item Add the Attributes like itemId, ItemName, ratePerUnit, category Provide 2 constructor -Zero and paramerized provde get/set methods

Create a Java Class ItemService Add overloaded methods to calculate discount

double findDiscount (Item item) // problem statement is intentionally incomplete here I If the customer is a Corporate customer allow a discount of 15%

Discount is given at 5%

double findDiscount (Item item, Customer customer)

If its a retails customer allow a discount of 10%

Create a Java Class Application

In the main the method take the input using Scanner Class The Application will work in a loop and it will terminate when the user gives a input to terminate
 */

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		Item it=new Item();
		Customer ct=new Customer();
		int ch;
		int itemId;
		String itemName,categery;
		double itemRate;
		while(true)
		{
			System.out.println("Enter your choice  1.For corparate Customer \n 2.For Regular \n 3.For Others");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
			}
		}

	}
	

}
class Item
{
	private int itemId;
	private String itemName,categery;
	private double itemRate;
	public Item() {
		super();
	}
	public Item(int itemId, String itemName, String categery, double itemRate) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.categery = categery;
		this.itemRate = itemRate;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategery() {
		return categery;
	}
	public void setCategery(String categery) {
		this.categery = categery;
	}
	public double getItemRate() {
		return itemRate;
	}
	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}
	
}
class Customer
{
	
	String custType,custName;

	public Customer() {
		super();
	}

	public Customer(String custType, String custName) {
		super();
		this.custType = custType;
		this.custName = custName;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}
class ItemService{
	private double totalPrice;
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double findDiscount(Item item)
	{
		totalPrice=item.getItemRate()-(item.getItemRate()*0.05);
		return totalPrice;
	}
	public double findDiscount(Item item,Customer cust) {
		if(cust.getCustType().equals("Corparate"))
		{
			totalPrice=item.getItemRate()-(item.getItemRate()*0.15);
		}
		else if(cust.getCustType().equals("Regular"))
		{
			totalPrice=item.getItemRate()-(item.getItemRate()*0.10);
		}
		else
		{
			totalPrice=findDiscount(item);
		}
		return totalPrice;
	}
}