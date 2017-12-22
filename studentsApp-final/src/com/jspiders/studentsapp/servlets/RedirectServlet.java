package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Donot generate the Response
		 * Instead Redirect the request
		 */
		//External
		//String url = "http://www.gmail.com";
		
		//Internal - Dynamic
		//String url = "http://localhost:8080/studentsApp/currentDate";
		//String url = "login";
		
		//Internal - Static
		String url = "index.html";
		resp.sendRedirect(url);
		
		
		
		
		
	}//End of doGet
}//End of Class
