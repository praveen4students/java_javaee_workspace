package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormExampleServlet 
extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		//Get the Form Data
		String myNameVal = req.getParameter("myName");
		String passVal = req.getParameter("pass");
		String genderVal = req.getParameter("gender");
		String educationVal = req.getParameter("education");
		
		String[] knowsVal = req.getParameterValues("knows");
		String[] ownsVal = req.getParameterValues("owns");
		
		String aboutmeVal = req.getParameter("aboutme");
		
		String msg = "Inside FormExampleServlet ";
		
		msg = msg + "My Name = "+myNameVal;
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(msg);
		
		
		
		
		
		
	}//End of doPost
}//End of Class
