package com.jspiders.corejava.lamda;

@FunctionalInterface
public interface LamdaInterface {
	
//	public void myMethod();
//	public String myMethod();
//	public void myMethod(String str);
	public String myMethod(String str1, String str2);
//	public String[] myMethod(String str1, String str2);
	
	//Object Class related Methods ===> "Public & Non-Final" Methods
	public String toString();
	public boolean equals(Object obj);
	public int hashCode();
	
	//"Protected & Non-Final" Methods Cannot be used
//	protected void finalize() throws Throwable;
//	protected native Object clone() throws CloneNotSupportedException;
}
