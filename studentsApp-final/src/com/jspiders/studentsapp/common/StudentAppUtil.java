package com.jspiders.studentsapp.common;

import java.io.FileReader;
import java.util.Properties;

/**
 * This is a Singleton Class & it reads the content of Property File present 
 * in C:\StudentApp.properties file
 * at the time of Creating an Instance of the Class. If the Property File is
 * not avilable then it reads the contnet from StudentAppConstants.java file
 * 
 * @author Praveen Dyamappa
 */
public class StudentAppUtil 
{
	private static StudentAppUtil instance = new StudentAppUtil();
	private String dbDriverClass = null;
	private String dbUrl = null;
	private String dbUserNM = null;
	private String dbPassword = null;
	
	/**
	 * Executed only once has logic of reading the Data from Proerty File
	 * @throws Exception 
	 */
	private StudentAppUtil()
	{
		try 
		{
			String fileLoc = "D:\\StudentApp.properties";
			FileReader reader = new FileReader(fileLoc);
			Properties prop = new Properties();
			prop.load(reader);
			
			this.setDbDriverClass(prop.getProperty("dbDriverClassNM"));
			this.dbUrl = prop.getProperty("dbURL");
			this.dbUserNM = prop.getProperty("dbUserName");
			this.dbPassword = prop.getProperty("dbPassword");
			
		} catch (Exception e) {
			this.setDbDriverClass(StudentAppConstants.DB_DRIVER_CLASS_NM);
			this.dbUrl = StudentAppConstants.DB_URL;
			this.dbUserNM = StudentAppConstants.DB_USER_NM;
			this.dbPassword = StudentAppConstants.DB_PASSWORD;
		}
	}//End of COnstructor
	
	public static StudentAppUtil getInstacnce()
	{
		return instance;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUserNM() {
		return dbUserNM;
	}

	public void setDbUserNM(String dbUserNM) {
		this.dbUserNM = dbUserNM;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbDriverClass() {
		return dbDriverClass;
	}

	public void setDbDriverClass(String dbDriverClass) {
		this.dbDriverClass = dbDriverClass;
	}
}//End of Class
