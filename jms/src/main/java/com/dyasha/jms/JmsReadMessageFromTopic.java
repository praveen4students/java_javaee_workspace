package com.dyasha.jms;

import static com.dyasha.jms.JMSAppConstants.ACTIVE_MQ_TOPIC;
import static com.dyasha.jms.JMSAppConstants.ACTIVE_MQ_URL;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsReadMessageFromTopic {

	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection con = factory.createConnection();
		con.start();
		
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createTopic(ACTIVE_MQ_TOPIC);

		MessageConsumer consumer = session.createConsumer(destination);
		
		TextMessage message = (TextMessage)consumer.receive();
		System.out.println("Message received .... Message is :- "+message.getText());
		
		con.close();

	}
}
