package com.cg.springAOPexample;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	private static Logger logger = Logger.getLogger("MainClass.class");
	public static void main(String[] args) {
		ApplicationContext atc = new ClassPathXmlApplicationContext("springEmployee.xml");
		Employee emp=(Employee) atc.getBean("employee");
		
		emp.run();
		System.out.println("ending the main class");
		
		try {
			emp.check(-1);
		} catch (Exception e) {
			
			logger.info("message sent via log4j\n");
			System.out.println("exception occured");
		}
		logger.warning("this is warning:");
		
	}

}
