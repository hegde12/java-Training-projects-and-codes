package com.example.demo;

public class NameNotFoundException  extends Exception{
	   String message;

		public NameNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String toString() {
			return "NameNotfoundException [error:" + message + "]";
		}
		   

}
