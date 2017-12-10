package com.dyasha.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsReadMessageFromQueue {
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(ACTIVE_MQ_QUEUE);
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		TextMessage message = (TextMessage)consumer.receive();
		System.out.println("Message received .... Message is :- "+message.getText());
		
		connection.close();
	}
}
