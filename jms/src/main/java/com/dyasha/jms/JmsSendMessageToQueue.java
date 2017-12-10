package com.dyasha.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsSendMessageToQueue {
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(ACTIVE_MQ_QUEUE);
		
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage("Hello World JMS");
		
		producer.send(message);
		System.out.println("Message Sent");
		
		connection.close();
	}
}
