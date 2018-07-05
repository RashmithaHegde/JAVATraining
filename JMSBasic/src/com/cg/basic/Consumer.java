package com.cg.basic;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ActiveMQConnectionFactory connectionFactory =
				new ActiveMQConnectionFactory("tcp://localhost:61616");
		
			Connection connection;
			
				connection = connectionFactory.createConnection();
			
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue("hena.TESTQ");
		
		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		System.out.println("msg rcvd: "+message);
		consumer.close();
		session.close();
		connection.close();
		
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

}
