package com.jspiders.studentsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspiders.studentsapp.common.StudentAppUtil;

public class StudentDAO 
{

	public StudentInfoBean authenticate(String regNum, String password)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentAppUtil util = StudentAppUtil.getInstacnce();
		try 
		{
			//1. Load the Driver
			//Driver Class : com.mysql.jdbc.Driver
			Class.forName( util.getDbDriverClass() ).newInstance();
			
			//2. Get the DB Connection via Driver 
			con = DriverManager.getConnection( util.getDbUrl(), util.getDbUserNM(), util.getDbPassword() );
			
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
			pstmt.setInt(1, Integer.parseInt(regNum) );
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			//4. Process the Results returned by SQL Queries
			if(rs.next())
			{
				StudentInfoBean bean = new StudentInfoBean();
				bean.setRegno(rs.getInt("si.regno"));
				bean.setFirstNM(rs.getString("si.firstname"));
				bean.setMiddleNM(rs.getString("si.middlename"));
				bean.setLastNM(rs.getString("si.lastname"));
				bean.setGfirstNM(rs.getString("gi.gfirstname"));
				bean.setGmiddleNM(rs.getString("gi.gmiddlename"));
				bean.setGlastNM(rs.getString("gi.glastname"));
				bean.setIsAdmin(rs.getString("soi.isadmin"));
				bean.setPassword(rs.getString("soi.password"));
				
				return bean;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	}//End of authenticate
	
	
}//End of Class
