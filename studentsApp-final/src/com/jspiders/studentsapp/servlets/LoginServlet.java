package com.jspiders.studentsapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.studentsapp.dao.StudentDAO;
import com.jspiders.studentsapp.dao.StudentInfoBean;

public class LoginServlet extends HttpServlet
{
	RequestDispatcher dispatcher = null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp)
	throws ServletException, IOException 
	{
		/*
		 * Check Cookies are enabled or not
		 * If Not Enabled then don't allow the 
		 * user to Login
		 */
		Cookie[] rcvdCookies = req.getCookies();
		if(rcvdCookies==null)
		{
			dispatcher = req.getRequestDispatcher("CookieNotEnabledError.html");
			dispatcher.forward(req, resp);
			return;
		}
		
		/*
		 * If Cookies are enabled in the User Browser
		 * then Allow him to access the web application
		 */
		
		//1. Get the Form Data
		String regNum = req.getParameter("regno");
		String password = req.getParameter("pass");
		String rememberMeChecked = req.getParameter("remember");
		
		/*
		 * If User has checked the "Remember Me" Check Box
		 * then send the user name as a Persistent Cookie information 
		 */
		if(rememberMeChecked!=null && rememberMeChecked.equals("yes"))
		{
			Cookie rememberMeCookie = new Cookie("alwaysRemember", regNum);
			//Persistent time = 7 Years (in Seconds)
			rememberMeCookie.setMaxAge(7*365*24*60*60);
			resp.addCookie(rememberMeCookie);
		}
		
		//2. Authenticate the Form Data
		StudentDAO dao = new StudentDAO();
		StudentInfoBean bean = dao.authenticate(regNum, password);
		
		String url = null;
		HttpSession session = null;
		if(bean != null) 
		{
			//Valid Credentials
			/*
			 * I. Create a Session for the First Time
			 */
			session = req.getSession(true);
			session.setMaxInactiveInterval(60);
			System.out.println("Session ID : "+session.getId());
			
			session.setAttribute("data", bean);
			session.setAttribute("regno", bean.getRegno());
			url = "home";
		}else{
			//In-Valid Credentials
			req.setAttribute("errMsg", "In-Valid User Name & Password !!!");
			url = "loginErr";
		}
		//Forward the request to Generate Response
		dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);

	}//End of doPost
}//End of Class
