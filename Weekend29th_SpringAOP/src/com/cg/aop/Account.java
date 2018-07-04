package com.cg.aop;

public class Account {

	public int withdraw() {
		int transactionId = 1001;
		System.out.println("Withdraw Called");
		return transactionId;
	}

	public void validate(int amount) throws Exception {
		if (amount < 0) {
			throw new ArithmeticException("Not valid amount");
		} else {
			System.out.println("Thanks for withdraw");
		}
	}
}
