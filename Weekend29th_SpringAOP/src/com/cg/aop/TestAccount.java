package com.cg.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("schemaaop.xml");
		Account account = (Account) ctx.getBean("account");
		account.withdraw();

		try {
			account.validate(-22);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("calling validate again...");

		try {
			account.validate(11);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
