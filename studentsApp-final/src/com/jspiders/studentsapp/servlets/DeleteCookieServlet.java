package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet 
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
			out.println("Cookies are Not Present in the Request to Delete !!!");
		}else{
			out.println("Cookies are Present ...");
			for(Cookie rcvdCookie : receivedCookies)
			{
				String name = rcvdCookie.getName();
				if(name.equals("myLocation"))
				{
					rcvdCookie.setMaxAge(0);
					resp.addCookie(rcvdCookie);
					out.println("Deleted the 'myLocation' Cooie");
					break;
				}//End of if
			}//End of for
		}//End of if-else
	}//End of doGet
}//End of Class
