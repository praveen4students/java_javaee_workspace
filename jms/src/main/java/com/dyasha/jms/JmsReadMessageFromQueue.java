package com.dyasha.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsReadMessageFromQueue implements MessageListener{
	private int count = 0;
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(ACTIVE_MQ_QUEUE);
		
		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(new JmsReadMessageFromQueue());
//		connection.close();
	}

	public void onMessage(Message message) {
		try {
			System.out.println("Message received .... Count :- "+(++count)+" Message is :- "+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
