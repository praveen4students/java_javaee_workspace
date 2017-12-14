package com.dyasha.camel.ftp;

public interface FTPServerDetails {
	
	/*
	 * Default Protocols
	 *  (ftp = 21, sftp = 22, ftps = 2222)
	 */
	String FTP_MYHOST = "localhost";
	String FTP_MYHOST_PORT = "21";
	String FTP_MYHOST_USER = "ftp_user";
	String FTP_MYHOST_PASSWORD = "qwerty"; 
	
	/*
	 * Refer the below site for FTP Server
	 * https://www.swfwmd.state.fl.us/data/ftp/
	 */
	String FTP_HOST_1 = "ftp.swfwmd.state.fl.us";
	String FTP_HOST_1_USER = "anonymous";
	String FTP_HOST_1_PASSWORD = ""; 
	
	
	/*
	 * One More ===> http://speedtest.tele2.net/
	 */
	String FTP_HOST_2 = "speedtest.tele2.net";
	String FTP_HOST_2_USER = "anonymous";
	String FTP_HOST_2_PASSWORD = "";
	
	/*
	 * Another ===> Server: test.talia.net 
	 */
	String FTP_HOST_3 = "speedtest.tele2.net";
	String FTP_HOST_3_USER = "anonymous";
	String FTP_HOST_3_PASSWORD = "";
	
}
