package com.jspiders.corejava.pattern;

public class PatternExample {

	private static final String STAR = "* "; 
	private static final String SPACE = "  "; 
	
	public static void main(String[] args) {
		//Square
	/*	int[][] data = {
							{1, 1, 1, 1}, 
							{1, 0, 0, 1},
							{1, 0, 0, 1},
							{1, 1, 1, 1},
						};*/
		
		
		//Rectangle
		/*int[][] data = {
						{1, 1, 1, 1, 1},
						{1, 0, 0, 0, 1},
						{1, 0, 0, 0, 1},
						{1, 1, 1, 1, 1},
		
					};*/
			
		//Arrow
		/*int[][] data = {
							{0, 0, 0, 0, 1, 0, 0},
							{0, 0, 0, 0, 1, 1, 0},
							{1, 1, 1, 1, 1, 1, 1},
							{0, 0, 0, 0, 1, 1, 0},
							{0, 0, 0, 0, 1, 0, 0},
						};*/
		//Triangle
		/*int[][] data = {
							{0, 0, 0, 1, 0, 0, 0},
							{0, 0, 1, 1, 1, 0, 0},
							{0, 1, 1, 1, 1, 1, 0},
							{1, 1, 1, 1, 1, 1, 1}
						};*/
		
		//Sorrow 
	/*	int[][] data = {
		{0, 0, 1, 0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 1, 1, 0},
		{1, 0, 0, 0, 0, 0, 0, 1},
		{1, 0, 0, 0, 0, 0, 0, 1}
	};*/
		
		int[][] data = {
				{0, 0, 1, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 1},
				{0, 1, 0, 0, 0, 0, 1, 0},
				{0, 0, 1, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}};
		printPattern(data);
	}//End of Main
	
	private static void printPattern(int[][] data){
		for(int[] rowData: data){
			printRow(rowData);
			System.out.println();
		}
	}
	
	private static void printRow(int[] rowData){
		
		for(int i:rowData){
			if(i==1){
				System.out.print(STAR);
			}else{
				System.out.print(SPACE);
			}
		}//End of for
		
	}//End of printRow
	
}//End of Class


