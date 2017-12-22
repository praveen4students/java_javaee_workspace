package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		/*
		 * Read the Cookies from Request
		 */
		Cookie[] receivedCookies = req.getCookies();
		if(receivedCookies==null)
		{
			out.println("Cookies are Not Present !!!");
		}else{
			out.println("Cookies are Present ...");
			for(Cookie rcvdCookie : receivedCookies)
			{
				String name = rcvdCookie.getName();
				String value = rcvdCookie.getValue();
				out.println(" Name : "+name);
				out.println(" Value : "+value);
			}
		}
		
		
		
	}//End of doGet
}//End of Class
