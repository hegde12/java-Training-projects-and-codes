package com.inhritence.ex;

public class Insurence {
	private int policyNo;
	private String policyName;
	private double amt;
	public Insurence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurence(int policyNo, String policyName, double amt) {
		super();
		this.policyNo = policyNo;
		this.policyName = policyName;
		this.amt = amt;
	}
	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	@Override
	public String toString() {
		return "Insurence [policyNo=" + policyNo + ", policyName=" + policyName + ", amt=" + amt + "]";
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public double calclatePremium()
	{
		double premium=5000;
		if(amt>1000000)
		{
			premium=10000;
		}
		return premium;
	}

}
