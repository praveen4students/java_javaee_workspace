package com.jspiders.corejava.threads;

public class MainMethodClass {

	public static void main(String[] args) {

		Thread_FirstWay firstThread = new Thread_FirstWay();
		firstThread.start();
		
		Thread_SecondWay secondThread = new Thread_SecondWay();
		Thread t = new Thread(secondThread);
		t.start();
		
		// Lambda Runnable
		Runnable lamdaThread = () -> { System.out.println("Lambda Thread is running"); };
		new Thread(lamdaThread).start(); // start the thread
		
	}//End of Main

}//End of Class
