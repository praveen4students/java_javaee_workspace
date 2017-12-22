import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail 
{
	public static void main(String[] args) 
	{
		/*
		 * Necessary Information to send mail 
		 */
		String from 	= "sample@gmail.com";
		String[] sendTo = {"mail_id_1@gmail.com", "mail_id_2@yahoo.com"};
		String subject 	= "Your Account Got Created";
		String mailContent = "<font color=\"blue\"> Your Account 1234 Got Created </font>";
		
		/*
		 * 1. Create a Properties object to contain 
		 *    settings for the SMTP protocol provider. 
		 */
		Properties props = new Properties();
		props.put("mail.smtp.auth", 			"true");
		props.put("mail.smtp.starttls.enable", 	"true");
		props.put("mail.smtp.host", 			"smtp.gmail.com");
		props.put("mail.smtp.port", 			"587");
		
		/*
		 * 2. If SMTP authentication is required you must set the 
		 *    mail.smtp.auth property to true and construct a Authenticator Instance 
		 *    that returns a PasswordAuthentication instance with your username and password.
		 */
		MyGmailAuthenticator gmailAuthenticator = new MyGmailAuthenticator();
		
		/*
		 * 3. Create a Session instance using the Properties object and the Authenticator object. 
		 * 	  If SMTP authentication in not needed a null value can be supplied for the Authenticator.
		 */
		Session session = Session.getDefaultInstance(props, gmailAuthenticator);
		//session.setDebug(true);	// method can be used to print out the current session's activity.
		
		try 
		{
			/*
			 * 4. Construct a MimeMessage instance, populate the message headers and content 
			 */
			Message message = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(from);
			InternetAddress[] addressTo = new InternetAddress[sendTo.length];
			for (int i = 0; i < sendTo.length; i++) {
				addressTo[i] = new InternetAddress(sendTo[i]);
			}
			
			message.setFrom(addressFrom);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			//message.setRecipients(Message.RecipientType.CC, addressTo);
			//message.setRecipients(Message.RecipientType.BCC, addressTo);
			message.setSubject(subject);
			
			//To Send the HTMl Mail
			message.setContent(mailContent,"text/html");
			
			//To Send the Text Mail
			//message.setText(mailContent);
 
			/*
			 * 5. Send the Email Message 
			 */
			Transport.send(message);
 
			System.out.println("Mail Sent ....");
 
		} catch (MessagingException e) {
			System.out.println("Mail Didn't Sent .... Please Check the Logs ....");
			throw new RuntimeException(e);
		}
	}
}