package com.dyasha.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsReadMessageFromTopicContinuously implements MessageListener{
	
	int count =0;
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection con = factory.createConnection();
		
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(ACTIVE_MQ_TOPIC);
		
		MessageConsumer consumer = session.createConsumer(topic);
		JmsReadMessageFromTopicContinuously jmsReciverTopic2 = new JmsReadMessageFromTopicContinuously();
		consumer.setMessageListener(jmsReciverTopic2);
		con.start();

	}

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage)message;
		try {
			System.out.println("Count:- "+(++count)+"Message: "+textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
