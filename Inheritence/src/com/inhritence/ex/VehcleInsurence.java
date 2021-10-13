package com.inhritence.ex;

public class VehcleInsurence extends Insurence {
	private String vehcleType;

	public VehcleInsurence() {
		super();
		System.out.println("0 param");
		// TODO Auto-generated constructor stub
	}

	public VehcleInsurence(int policyNo, String policyName, double amt,String vehcleType) {
		super(policyNo, policyName, amt);
		// TODO Auto-generated constructor stub
		this.vehcleType=vehcleType;
		System.out.println("param constuctor");
	}

	public String getVehcleType() {
		return vehcleType;
	}

	public void setVehcleType(String vehcleType) {
		this.vehcleType = vehcleType;
	}

	@Override
	public String toString() {
		return "VehcleInsurence [vehcleType=" + vehcleType + ", getVehcleType()=" + getVehcleType() + ", getPolicyNo()="
				+ getPolicyNo() + ", toString()=" + super.toString() + ", getPolicyName()=" + getPolicyName()
				+ ", getAmt()=" + getAmt() + ", calclatePremium()=" + calclatePremium() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public double calclatePremium() {
		// TODO Auto-generated method stub
		double premium=500;
		switch(vehcleType.toLowerCase()) {
		case "car": if(getAmt()>50000)
		{
			premium=1000;
		}
		break;
		case "bike":if(getAmt()>5000) {
			premium=700;
		}
		break;
		}
		return premium;
	}
	
	
	
	
}
