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
import javax.servlet.http.HttpSession;

import com.jspiders.studentsapp.dao.StudentDAO;
import com.jspiders.studentsapp.dao.StudentInfoBean;

public class HomePageServlet extends HttpServlet
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
		HttpSession session = req.getSession(false);
		if(session==null)
		{
			//Invalid Session; Generate Login Page
			req.setAttribute("errMsg", "In-Valid Session !!! Pls Login ...");
			String url = "loginErr";
			dispatcher = req.getRequestDispatcher(url);
			dispatcher.include(req, resp);
		}else{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			StudentInfoBean bean 
				= (StudentInfoBean)session.getAttribute("data");
			
			dispatcher = req.getRequestDispatcher("Header.html");
			dispatcher.include(req, resp);
			
			String searchUrl = "./bodyWithHeaderFooter?page=Search.html";
			String encodedSearchUrl = resp.encodeURL(searchUrl);
			
			out.println("<a href=\""+encodedSearchUrl+"\"> Click Here </a> to Search a Reg. No.");
			out.println("</BR></BR>"); 
			
			out.println("<html>"); 
			out.println("<body>"); 
			out.println("<table>");
			out.println("<tr bgcolor=\"pink\"> ");
			out.println("<td>Reg. No. </td>");
			out.println("<td>First Name</td>");
			out.println("<td>Middle Name</td>");
			out.println("<td>Last Name</td>");
			out.println("<td>G First Name</td>");
			out.println("<td>G Middle Name</td>");
			out.println("<td>G Last Name</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>"+bean.getRegno()+"</td>");
			out.println("<td>"+bean.getFirstNM()+"</td>");
			out.println("<td>"+bean.getMiddleNM()+"</td>");
			out.println("<td>"+bean.getLastNM()+"</td>");
			out.println("<td>"+bean.getGfirstNM()+"</td> ");
			out.println("<td>"+bean.getGmiddleNM()+"</td>");
			out.println("<td>"+bean.getGlastNM()+"</td>  ");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>"); 
			out.println("</html>");
			
			dispatcher = req.getRequestDispatcher("Footer.html");
			dispatcher.include(req, resp);
		}
		
			
	}//End of doPost
}//End of Class
