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

import com.mysql.jdbc.Driver;

public class LoginServlet extends HttpServlet {

	RequestDispatcher dispatcher =null;
	
	@Override
	protected void doPost(HttpServletRequest req, 
						 HttpServletResponse resp) 
	throws ServletException, IOException {
		
		//Get the Form Data
		String regnoVal = req.getParameter("regno");
		String passVal = req.getParameter("pass");

		/* II. Authenticate the Credentials by 
		*      interacting with DB & Generate 
		*      the Response
		*/
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			//1. Load the Driver
			//Driver Class : com.mysql.jdbc.Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. Get the DB Connection via Driver 
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection 
			String query = " select * from "+
							" students_info si, "+
							" guardian_info gi, "+
							" students_otherinfo soi "+
							" where si.regno = gi.regno "+
							" and si.regno = soi.regno "+
							" and soi.regno = ? "+
							" and soi.password = ? ";
			
			System.out.println("Query : "+query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(regnoVal) );
			pstmt.setString(2, passVal);
			rs = pstmt.executeQuery();
			
			//4. Process the Results returned by SQL Queries
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			
			if(rs.next())
			{
				//Valid credentials
				//I. Create a Session
				HttpSession session = req.getSession(true);
				//Time in Sec.
				session.setMaxInactiveInterval(1*60);
				
				session.setAttribute("userName", regnoVal);
				session.setAttribute("isAdmin", rs.getString("soi.isadmin"));
				
				System.out.println("Session ID ---> "+session.getId());
				
				
				int regnum = rs.getInt("regno");
				String fNM = rs.getString("firstname");
				String mNM = rs.getString("middlename");
				String lNM = rs.getString("lastname");
				String gfNM = rs.getString("gi.gfirstname");
				String gmNM = rs.getString("gi.gmiddlename");
				String glNM = rs.getString("gi.glastname");
				String isAdmin = rs.getString("soi.isadmin");
				
				dispatcher=req.getRequestDispatcher("headerPage");
				dispatcher.include(req, resp);

				out.println("<html>");
				out.println("<body>");
				
				if(isAdmin.equals("Y")){
					String url = "./allStudentsView";
					String encodedUrl = resp.encodeURL(url);
					out.println("<a href=\""+encodedUrl+"\">Click Here</a> to View All Students Info");
					out.print("<BR>");
				}
				
				out.println("<table>");
				out.println("<tr bgcolor=\"green\">");
				out.println("<td>Reg. No.</td>");
				out.println("<td>First Name</td>");
				out.println("<td>Middle Name</td>");
				out.println("<td>Last Name</td>");
				out.println("<td>G First Name</td> ");
				out.println("<td>G Middle Name</td>");
				out.println("<td>G Last Name</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>"+regnum+"</td>");
				out.println("<td>"+fNM+"</td>");
				out.println("<td>"+mNM+"</td> ");
				out.println("<td>"+lNM+"</td>");
				out.println("<td>"+gfNM+"</td>");
				out.println("<td>"+gmNM+"</td> ");
				out.println("<td>"+glNM+"</td>");
				out.println("</tr>");
				out.println("</table>");
				dispatcher=req.getRequestDispatcher("Footer.html");
				dispatcher.include(req, resp);
				
			}else{
				out.print("<font color=\"red\">");
				out.println("In-Valid User Name / Password");
				out.print("</font>");
				
				dispatcher=req.getRequestDispatcher("Login.html");
				dispatcher.include(req, resp);
			}
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//5. Close All JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch block
		
	}//End of doPost
}//End of Class
