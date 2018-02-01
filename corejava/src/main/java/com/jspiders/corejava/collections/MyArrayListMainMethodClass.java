package com.jspiders.corejava.collections;

public class MyArrayListMainMethodClass {
	
	public static void main(String[] args) {
	
		int counter = 15;
		MyArrayList<String> list = new MyArrayList<String>();
		
		System.out.println("Adding Values to My Array List ...");
		for(int i=1; i<=counter; i++) {
			list.add(i+"");
		}
		System.out.println("===========================================");
		
		System.out.println("Reading Values from My Array List ...");
		for(int i=0; i<counter; i++) {
			System.out.println( list.get(i) );
		}
		System.out.println("===========================================");
		
		System.out.println("Removing the Values from My Array List ...");
		for(int i=0; i<counter; i++) {
			list.remove(0);
		}
		System.out.println("===========================================");
		
	}//End of Main
}//End of Class
