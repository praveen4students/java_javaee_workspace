package com.dyasha.jms;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import static com.dyasha.jms.JMSAppConstants.*;

public class JmsSendJsonMessageToTopic {
	
	public static void main(String[] args) throws Exception {

		ConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
		Connection connection = factory.createConnection();
		connection.start();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter();
		String str = mapper.writeValueAsString(new Employee(1, "Praveen", "D"));
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic(ACTIVE_MQ_TOPIC);
		MessageProducer producer = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage(str);
		producer.send(message);
		
		connection.close();
	}
}
