package com.thread.exmp;

public class InterThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
class DepositTask implements Runnable{
	ThreadExample ex;
	
	public DepositTask(ThreadExample ex) {
		super();
		this.ex = ex;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

class WithdrawalTask implements Runnable{
	ThreadExample ex;
	public WithdrawalTask(ThreadExample ex) {
		super();
		this.ex = ex;
	}
	Thread t=new Thread(this);
	t.start();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
