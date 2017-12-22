import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMailUtil 
{
	
	public static boolean sendMail(String fromAddr, String[] toAddr, String subject, String mailContent,
								   boolean isHTML, String filePathAndName)
	{
		/*
		 * 1. Create a Properties object to contain 
		 *    settings for the SMTP protocol provider. 
		 */
		Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
			InternetAddress addressFrom = new InternetAddress(fromAddr);
			InternetAddress[] addressTo = new InternetAddress[toAddr.length];
			for (int i = 0; i < toAddr.length; i++) {
				addressTo[i] = new InternetAddress(toAddr[i]);
			}
			
			message.setFrom(addressFrom);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(subject);
			
			if(filePathAndName == null)
			{
				if(isHTML){
					message.setContent(mailContent,"text/html");
				}else{
					message.setText(mailContent);
				}
				
			}else{
				/*
				 * Create a MimeMultipart instance. A mulit-part message consists 
				 * of multiple parts, in this case mail message & file attachment.
				 */
				Multipart multipart = new MimeMultipart();
				
				/*
				 * Construct the email body
				 */
				MimeBodyPart messagePart = new MimeBodyPart();
				if(isHTML){
					messagePart.setContent(mailContent, "text/html");
				}else{
					messagePart.setText(mailContent);
				}
				/*
				 * Add email Body to Multipart Message
				 */
				multipart.addBodyPart(messagePart);
				
				/*
				 * Add attachment to email
				 */
				MimeBodyPart attachmentPart = new MimeBodyPart();
				FileDataSource fileDataSource = new FileDataSource(filePathAndName) {
													@Override
													public String getContentType() {
														return "application/octet-stream";
													}
												};
				attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				attachmentPart.setFileName(fileDataSource.getName());
				
				/*
				 * Add email attachment to Multipart Message
				 */
				multipart.addBodyPart(attachmentPart);
			
				/*
				 * Add Multipart Message to MimeMessage instance
				 */
				message.setContent(multipart);
			}
			
			/*
			 * 5. Send the Email Message 
			 */
			Transport.send(message);
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}//End of Try-Catch
		
	}//End of Send Mail
	
}//End of Class
