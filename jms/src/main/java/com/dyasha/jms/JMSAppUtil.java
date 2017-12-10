package com.dyasha.jms;

import static com.dyasha.jms.JMSAppConstants.ACTIVE_MQ_URL;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSAppUtil {

	private static final JMSAppUtil REF = new JMSAppUtil();
	private static final ConnectionFactory FACTORY = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
	
	private JMSAppUtil() {}
	
	public static Connection getConnection() throws JMSException {
		return FACTORY.createConnection();
	}
	
}
