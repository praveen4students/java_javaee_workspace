package com.mycomp.myjavaapp.common;

public class PatternUtil {
	
	private static final String STAR = "* ";
	private static final String SPACE = "  ";
	
	private PatternUtil() {}
	
	public static void printpattern(int[][] pattern){
		for(int[] data : pattern){
			printRow(data);
		}
	}
	
	private static void printRow(int[] rowData){
		
		for(int data : rowData){
			System.out.print( (data==1) ? STAR : SPACE);
		}
		
		System.out.println();
		
	}//End of printRow
}
