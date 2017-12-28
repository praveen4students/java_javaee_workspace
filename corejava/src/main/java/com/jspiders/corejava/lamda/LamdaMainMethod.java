package com.jspiders.corejava.lamda;

public class LamdaMainMethod {
	
	public static void main(String[] args) {
		
		/*LamdaInterface ref = () -> {
										System.out.println("Hello !!!");
								   };
		ref.myMethod();*/
		
		
		/*LamdaInterface ref = () -> {
										System.out.println("Hello !!!");
										return "Hello ...";
									};
		System.out.println( ref.myMethod() );*/
		
		
		/*LamdaInterface ref = (s) -> {
			System.out.println(s + "Hello !!!");
		};
		ref.myMethod("Hi... ");*/
		
		LamdaInterface ref = (s1, s2) -> {
			System.out.println(s1 + "Hello !!!" + s2);
			return s1 + "Hello !!!" + s2;
		};
		System.out.println( ref.myMethod("Hi... ", " How are You?") );
		
		/*LamdaInterface ref = (s1, s2) -> {
			System.out.println(s1 + "Hello !!!" + s2);
			return new String[]{s1, "Hello !!!", s2};
		};
		String[] vals = ref.myMethod("Hi... ", " How are You?");
		for(String val : vals) {
			System.out.println(val);
		}*/
		
	}//End of Main
}//End of Class
