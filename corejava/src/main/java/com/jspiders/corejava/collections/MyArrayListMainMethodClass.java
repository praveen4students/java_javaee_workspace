package com.jspiders.corejava.collections;

import java.util.ArrayList;

public class MyArrayListMainMethodClass {
	
	public static void main1(String[] args) {
		
		//Array List Remove Logic; copied from Array List class
		String[] test = {"1","2","3","4","5"};
		int index = 2;  //position to remove
		int size = test.length;
		int numMoved = size - index - 1;
		System.arraycopy(test, index+1, test, index, numMoved);
		test[--size] = null;
		System.out.println(test);
	}
	
	public static void main(String[] args) {
	
		int counter = 15;
		MyArrayList<String> list = new MyArrayList<String>();
		
		System.out.print("My Array List Size Empty ? ");
		System.out.println( list.isEmpty() );
		System.out.println("===========================================");
		
		System.out.println("Adding Values to My Array List ...");
		for(int i=1; i<=counter; i++) {
			list.add(i+"");
		}
		System.out.println("===========================================");
		
		System.out.println("Reading Values from My Array List using Traditional For Loop ...");
		for(int i=0; i<counter; i++) {
			System.out.println( list.get(i) );
		}
		System.out.println("===========================================");
		
		System.out.println("Reading Values from My Array List using For-Each Loop ...");
		for(String str : list) {
			System.out.println( str );
		}
		System.out.println("===========================================");
		
		System.out.print("My Array List Size is = ");
		System.out.println( list.size() );
		System.out.println("===========================================");
		
		System.out.print("My Array List Size Empty ? ");
		System.out.println( list.isEmpty() );
		System.out.println("===========================================");
		
		System.out.println("Trimming My Array List ...");
		list.trimToSize();
		System.out.println("===========================================");
		
		System.out.println("Removing the Values from My Array List ...");
		for(int i=0; i<counter; i++) {
			list.remove(0);
		}
		System.out.println("===========================================");
		
	}//End of Main
}//End of Class
