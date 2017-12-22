package com.jspiders.studentsapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet 
extends HttpServlet
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * III. In-Validate the Session 
		 */
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
		}
		//Generate Login Page
		req.setAttribute("errMsg", "Thanks for stopping by!!! We hope to see you again soon.");
		req.setAttribute("color", "green");
		dispatcher = req.getRequestDispatcher("loginErr");
		dispatcher.include(req, resp);
		
		
	}
}
