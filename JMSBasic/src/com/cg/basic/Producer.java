package com.cg.basic;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class Producer {

	public static void main(String[] args) {
		try {
		ActiveMQConnectionFactory connectionFactory =
				new ActiveMQConnectionFactory("tcp://localhost:61616");
		
			Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("hena.TESTQ");
		
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		String text = "HI DISNEY...LEARN JMS" ;//+ Thread.currentThread().getName();
		TextMessage message = session.createTextMessage(text);
		System.out.println("msg sent: " +message.getText());
		producer.send(message);
		
		session.close();
		connection.close();
		
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
