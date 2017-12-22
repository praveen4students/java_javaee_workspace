package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GraingerSearchServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		String url = "http://www.grainger.com/search?searchQuery=";
		
		//Get the Form Data
		String keywordVal = req.getParameter("keyword");
		
		//Redirect The Request to 
		//http://www.grainger.com
		resp.sendRedirect(url+keywordVal);
		
	}//End of doPost
}//End of Class
