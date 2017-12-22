
public class TestMail {

	public static void main(String[] args) 
	{
		String from 	= "sample@gmail.com";
		String[] sendTo = {"pavanecea7@gmail.com", "manjuias22@yahoo.com"};
		String subject 	   = "Your Account Got Created";
		String mailContent = "<font color=\"yellow\"> Your Account 1234 Got Created !!!! </font>";
		String fileName    = "D:\\Praveen\\Apprisal.txt";
		boolean mailSent   = false;
		
		//Text Email Message - Without Attachment
		//mailSent = SendMailUtil.sendMail(from, sendTo, subject, mailContent, false, null); 
		
		//HTML Email Message - Without Attachment
		mailSent = SendMailUtil.sendMail(from, sendTo, subject, mailContent, true, null);  
		
		//Text Email Message - With Attachment
		//mailSent = SendMailUtil.sendMail(from, sendTo, subject, mailContent, false, fileName); 
		
		//HTML Email Message - With Attachment
		//mailSent = SendMailUtil.sendMail(from, sendTo, subject, mailContent, true, fileName);  
		
		if(mailSent){
			System.out.println("Mail Sent !!!!");
		}else{
			System.out.println("Mail Didn't Sent .... Pls check the error logs");
		}
	}//End of Main Method

}//End of Class
