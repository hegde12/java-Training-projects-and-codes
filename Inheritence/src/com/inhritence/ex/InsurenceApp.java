package com.inhritence.ex;

public class InsurenceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insurence lf=new Insurence(1000,"Gireesh",5678900);
		System.out.println("Man premium  "+lf.calclatePremium());
		VehcleInsurence vi=new VehcleInsurence(1222,"Ganesh",5000000,"car");
		System.out.println("Vehcle Insurence  "+vi.calclatePremium());
	}

}
