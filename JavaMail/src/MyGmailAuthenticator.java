import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MyGmailAuthenticator extends Authenticator
{
	protected PasswordAuthentication getPasswordAuthentication() 
	{
		return new PasswordAuthentication("j2eejavamailapi@gmail.com","redminote3");
	}
}
