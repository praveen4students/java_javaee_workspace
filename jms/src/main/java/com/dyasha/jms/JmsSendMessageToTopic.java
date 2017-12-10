package com.dyasha.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsSendMessageToTopic {
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection con = factory.createConnection();
		con.start();
		
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(ACTIVE_MQ_TOPIC);
		
		MessageProducer producer = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage("Hello World");
		producer.send(message);
		
		System.out.println("Message Brodcasted");
		
		con.close();
	}
}
