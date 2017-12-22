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

import com.jspiders.studentsapp.dao.StudentDAO;
import com.jspiders.studentsapp.dao.StudentInfoBean;

public class LoginErrorServlet extends HttpServlet
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException 
	{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String errInfo = (String)req.getAttribute("errMsg");
		String msgColor = (String)req.getAttribute("color");
		
		if(msgColor==null || msgColor.equals("")){
			msgColor="red";
		}
		
		out.println("<h2><font color=\""+msgColor+"\">"); 
		out.println(errInfo);
		out.println("</font></h2>"); 
		out.println("</BR>"); 
		dispatcher = req.getRequestDispatcher("Login.html");
		dispatcher.include(req, resp);
	}//End of doPost
}//End of Class
