package com.oneExp.iface;

public class WeatherSevice1 implements WeatherService {

	@Override
	public void getWeather(String city) {
		// TODO Auto-generated method stub
		String w="29 -cool";
		if(city.equals("CHN"))
		{
			System.out.println("very hot");
		}
		else
			System.out.println(w);
	}

}
