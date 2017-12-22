package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class MyFirstServlet extends HttpServlet
implements SingleThreadModel
{
	static{
		System.out.println("My Static Block ...");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Inside Main Method ...");
	}
	
	public MyFirstServlet() 
	{
		System.out.println("Inside Constructor ...");
	}
	
	@Override
	public void init() 
	throws ServletException 
	{
		System.out.println("Inside init() Method ...");
	}
	@Override
	protected synchronized void doGet(HttpServletRequest req, 
					   HttpServletResponse resp)
	throws ServletException, IOException 
	{
		System.out.println("Inside service() Method ...");
		
		//Java Code to Generate Date & Time
		Date dateRef = new Date();
		String currDate = dateRef.toString();
		
		//Get the Query Parameters
		String fNM = req.getParameter("fname");
		String lNM = req.getParameter("lname");
		
		//Error Simulation
		//int i = 100/0;
		
		//Generate HTML Response
		/*String htmlRes = "<html>" 
						 +"<body>" 
						 +"<h1>" 
						 +"Current Date & Time is :" 
						 +"<font color=\"red\">" 
						 +currDate
						 +"</font>" 
						 +"</h1>"
						 +"<BR/><BR/>"
						 +"First Name : "
						 +fNM
						 +"<BR/>"
						 +"Last Name : "
						 +lNM
						 +"</body>" 
						 +"</html>";*/
		
		//Send HTML Response to Browser
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		//out.println(htmlRes);
		out.println("<html>"); 
		out.println("<body>"); 
		out.println("<h1>"); 
		out.println("Current Date & Time is :"); 
		out.println("<font color=\"red\">"); 
		out.println(currDate);
		out.println("</font>"); 
		out.println("</h1>");
		out.println("<BR/><BR/>");
		out.println("First Name : ");
		out.println(fNM);
		out.println("<BR/>");
		out.println("Last Name : ");
		out.println(lNM);
		out.println("</body>"); 
		out.println("</html>");
	}//End of doGet
	
	@Override
	public void destroy() 
	{
		System.out.println("Inside destroy() Method ...");
	}
	
	
	
}//End of Class
