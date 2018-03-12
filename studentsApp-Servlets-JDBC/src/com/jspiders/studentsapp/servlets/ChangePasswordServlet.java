package com.jspiders.studentsapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordServlet extends HttpServlet 
{
	RequestDispatcher dispatcher =null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						  HttpServletResponse resp)
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// Get the Form Data
		String regnoVal = req.getParameter("regno");
		String currPassVal = req.getParameter("currPass");
		String newPassVal = req.getParameter("newPass");
		String reNewPassVal = req.getParameter("reNewPass");

		dispatcher=req.getRequestDispatcher("Header.html");
		dispatcher.include(req, resp);
		
		dispatcher=req.getRequestDispatcher("ChangePassword.html");
		dispatcher.include(req, resp);
		out.print("<BR><BR>");
		
		// Check New Password & Retype New Password is Same
		if (newPassVal.equals(reNewPassVal)) {
			// New Password = Retype New Password; Hence Update
			Connection con = null;
			PreparedStatement pstmt = null;
			try 
			{
				//1. Load the Driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				//2. Get the DB Connection via Driver 
				String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
				con = DriverManager.getConnection(dbUrl);

				//3. Issue SQL Queries via Connection 
				String query = " update students_otherinfo "
								+ " set password=? " 
								+ " where Regno=? "
								+ " and password=? ";
				
				System.out.println("Query : "+query);
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, newPassVal);
				pstmt.setInt(2, Integer.parseInt(regnoVal));
				pstmt.setString(3, currPassVal);
				int count = pstmt.executeUpdate();
				
				//4. Process the Results returned by SQL Queries
				out.print("<html> ");
				out.print("<body> ");
				if (count > 0) {
					out.print("<font color=\"green\">"); 
					out.print("Successfully Changed the Password ...");
					out.print("</font>");
				} else {
					out.print("<font color=\"red\">"); 
					out.print("Reg. No. & Current Password Doesn't Match !!!");
					out.print("</font>");
				}
				
			} catch (Exception e) {

			} finally {
				//5. Close All JDBC Objects
				try 
				{
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			out.print("<font color=\"red\">"); 
			out.print("New Password & Re-type New Password Doesn't Match !!!");
			out.print("</font>");
		}
		
		out.print("</body>");
		out.print("</html>");
		
		dispatcher=req.getRequestDispatcher("Footer.html");
		dispatcher.include(req, resp);

	}//End of doPost
}//End of Class
